#### `Behavior`的作用及原理
`Behavior`是一个View的触摸事件相关的的代理.拦截`child`的触摸事件.

`Behavior`基与观察者模式,通过观察目标改变.来改变对应的`child`(不仅仅是嵌套滑动)

`Behavior`的基类是`CoordinatorLayout.Behavior<V extends View>`,所有方法都是非抽象的空实现.可以看做是一个接口的默认实现类
*
* `public boolean layoutDependsOn(CoordinatorLayout parent, V child, View dependency)`

    此方法用来配对被观察的View(`dependency`)及响应的View(`child`).如果返回true表示配对成功

    `Behavior`,设置方法如下
    * 在xml中使用`app:layout_behavior`
    * 在代码中设置,`new`出`Behavior`,设置在`CoordinatorLayout.layoutParams`中
    * 在类中使用注解,如`@CoordinatorLayout.DefaultBehavior(AppBarLayout.Behavior.class)`,括号中就是需要绑定的`Behavior`

        使用此方法`CoordinatorLayout`会在`inflater`中能过反射生成对应的`Behavior`,并设置在`layoutParams`中
* `public boolean onDependentViewChanged(CoordinatorLayout parent, V child, View dependency)`

    当目标组件`dependency`发生变化时的回调

![`Behavior家族`](Behavior.png)