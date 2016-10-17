#### `CoordinatorLayout`的作用及原理
`CoordinatorLayout`是`ViewGroup`的子类,实现了`NestedScrollingParent`,所以官方建议做为根布局来统筹其子类的嵌套滑动.
* 工作原理.
    * `layout_behavior`属性是记录在`CoordinatorLayout.layoutParams`里的.`CoordinatorLayout`从中获取`Behavior`,再把直接子组件拿来与之配对.
    *  `CoordinatorLayout`,把目标组件传递的滑动距离交给对应的组件的`Behavior`进行消费,然后`ScrollAble`自身进行消费.其起到一个桥梁的作用
* 使用了`Map<View,ArrayList<View>>`来保存`viewChild`和它的`dependencyView`
* 通过`static Behavior parseBehavior(Context context, AttributeSet attrs, String name) {
`方法解析`xml`中的`behavior`.在方法中获取`Behavior`的全类名,通过反射创建实例.使用`Map`来一对一的保存类名和对应的类.
* 通过`getResolvedLayoutParams(View child)`方法来检测是否有`Behavior`的注解.如果有则通过反射来创建实例
* 在`onMeasure`,`onLayout`,`onStartNestScroll`中会调用`Behavior`的回调方法.
在`onChildViewsChanged`时调用`Behavior`的`onDependencyChangeed`方法
* 使用了一个成员变量`mBehaviorTouchView` 当前接收触摸事件带有`Behavior`的View.

    每次新的触摸事件开始时对个这变量的`Behavior`进行重置.重置方法为`private void resetTouchBehaviors()`
    * 获取该`View`的`Behavior`.
    * 以当前时间点创建一个`OnCancel`的触摸事件.
    * 让`Behavior`接收该事件.
    * `View`置为`null`