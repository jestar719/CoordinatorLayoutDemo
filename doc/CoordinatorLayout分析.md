#### `CoordinatorLayout`的作用及原理
`CoordinatorLayout`是`ViewGroup`的子类,实现了`NestedScrollingParent`,所以官方建议做为根布局来统筹其子类的嵌套滑动.

##### 工作原理.
*  `CoordinatorLayout`把目标组件的触摸事件进行拦截.调用对应的`Behavior`的相关方法进行处理.
* `layout_behavior`属性是记录在`CoordinatorLayout.layoutParams`里的.`CoordinatorLayout`从中获取`Behavior`,再把直接子组件拿来与之配对.

##### 工作流程
* 重置`Behavior`

    在一个事件流中需要确定关联的子组件,设置到对应的`Behavior`中,这个我称之为配对.那么对应的,解除子组件之间的关联可以称之为重置.

    `CoordinatorLayout`使用了一个成员变量`mBehaviorTouchView` 保存当前接收触摸事件带有`Behavior`的View.

     在`attachWindow`,`dettachWindow`及触摸事件中`DOWN`,`UP`和`CANCEL`时,对个这变量及其`Behavior`进行重置.重置方法为`private void resetTouchBehaviors()`

     * 获取该`View`的`Behavior`.
     * 以当前时间点创建一个`OnCancel`的触摸事件.
     * 让`Behavior`接收该事件.
     * `mBehaviorTouchView`置为`null`
*  事件拦截

   `CoordinatorLayout`拦截所有子组件的触摸事件.来决断是交给`Behavior`来处理还是子组件自身处理.

    在`Down`,`UP`,`CANCEL`时重置`Behavior`

    通过`performIntercept`方法来拦截触摸事件,如果拦截了触摸事件则后继续的事件都是在自己的`OnTouchEvent`里处理,这时也会调用`performIntercept`来处理.

    `private boolean performIntercept(MotionEvent ev, final int type)`

     `type`有两种,`TYPE_ON_INTERCEPT`和`TYPE_ON_TOUCH`,用与表示是在什么时候调此方法的

     * 获取直接子组件的集合,此集合以子组件的Z轴排序过,表层的排在前面.
     * 遍历子组件,如果子组件存在`Behavior`则调用`Behavior`的`onIntercept`方法处理事件,
        如果返回`true`则表示此次事件流由此`Behavior`处理.从而确定了`mBehaviorTouchView`.开启此次事件流的拦截.

        ````
                for (int i = 0; i < childCount; i++) {
                    final View child = topmostChildList.get(i);
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    final Behavior b = lp.getBehavior();
                     if (!intercepted && b != null) {
                                    switch (type) {
                                        case TYPE_ON_INTERCEPT:
                                            intercepted = b.onInterceptTouchEvent(this, child, ev);
                                            break;
                                        case TYPE_ON_TOUCH:
                                            intercepted = b.onTouchEvent(this, child, ev);
                                            break;
                                    }
                                    if (intercepted) {
                                        mBehaviorTouchView = child;
                                    }

                    }
        ````





* 使用了`Map<View,ArrayList<View>>`来保存`viewChild`和它的`dependencyView`
* 通过`static Behavior parseBehavior(Context context, AttributeSet attrs, String name) {
`方法解析`xml`中的`behavior`.在方法中获取`Behavior`的全类名,通过反射创建实例.使用`Map`来一对一的保存类名和对应的类.
* 通过`getResolvedLayoutParams(View child)`方法来检测是否有`Behavior`的注解.如果有则通过反射来创建实例
* 在`onMeasure`,`onLayout`,`onStartNestScroll`中会调用`Behavior`的回调方法.
在`onChildViewsChanged`时调用`Behavior`的`onDependencyChangeed`方法


