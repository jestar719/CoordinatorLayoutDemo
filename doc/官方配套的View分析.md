#### `AppBarLayout`的作用及原理
`AppBarLayout`是`LinearLayout`的子类,方向强制为`vertical`

`AppBarLayout.Behavior`是`AppBarLayout`的内部类.

在`AppBarLayout`的声明上使用注解标注了`@CoordinatorLayout.DefaultBehavior(AppBarLayout.Behavior.class)`

对应的是在`xml`中可滑动组件上的`app:layout_behavior="@string/appbar_scrolling_view_behavior"`属性

对标注了`@string/appbar_scrolling_view_behavior`组件的滑动进行响应,控制其标了`app:layout_scrollFlags="scroll"`的直接子类进行嵌套滑动.

#### `AppBarLayout`的使用及细节
* 只能控制直接子类进行嵌套滑动
* include的view.`layout_scollFlags`属性必须标注在原xml的根组件上
* 夹在两个不`scroll`的组件之间的组件,`layout_scrollFlags`属性无效
* `layout_scrollFlags`属性说明

    可以通过`|`来多个属性叠加,`scroll`属性必须放在第一位,没有则其它属性无效
    * `scroll` 标了此属性的view才能响应嵌套滑动
    * `snap` 附加属性,提供了弹性拉动的效果.松手时view只能全显示/全不显示
    * `enterAlways` 附加属性,标注了此属性的组件.在向下滑动时会全显示,
    向上滑动消失