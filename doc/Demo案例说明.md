### Demo说明
##### 官方样例1及扩展
`AppBarLayout`和其`Behavior`的基础应用.演示了怎么通过`layout_scrollFlags`和`Behavior`在xml中的使用.
基本结构如下

``
<CoordinatorLayout>
    <AppBarLayout>
    <View
    ...
    app:layout_scrollFlags="xxx"
    />
    <View
        ...
        app:layout_scrollFlags="xxx"
        />
     </AppBarLayout>
</CoordinatorLayout>
``
在扩展中演示了不同的`layout_scrollFlags`组合的效果.

使用说明
* `layout_scrollFlags`的属性说明,可以通过`|`符号来组合多个属性
    *  `scroll`,滑动的基础,必须放在第一位.有此属性才能响应滑动
    *  `snap`为滑动增加弹性效果,在放手时全显示/全不显示
    * `enterAlwyas` 只要向下滑动就显示,向上滑动就隐藏
* `AppBarLayout`的滑动是从上至下的遍历子组件,直到遇到没有`scroll`属性的子组件.其后其它子组件无论有无`scroll`属性都视为无
* `layout_scrollFlags`只对AppBarLayout的直接子组件有效.
* 使用`include`导入的组件,除非原布局文件中根节点中含有`layout_scrollFlags`,否则视为无此属性.在`include`上添加无效

``
<include layout="@layout:xxxxx" layout_scrollFlags="xxx"/>
``
这样是无效的

如果想使用`include`可以使用`Framlayout`等布局,设置`layout_scrollFlags`,然后包裹它.如

    ``
    <FramLayout
    ...
   layout_scrollFlags="xxx"
    >
        <include layout="@layout:xxxxx" />
     </FramLayout>
    ``

##### 官方样例2

演示了`CollapsingToolbarLayout`的基本使用.
新出现了`layout_scrollFlags`的新属性`exitUntiCollapsed`,`enterAlwaysCollapsed`及`app:layout_collapseMode`的配合效果
当折叠时,`layout_collapseMode`开始起作用.这里使用的是`pin`表示固定不动.
* `exitUntilCollapsed`拉的时候，这个View会跟着滑动直到折叠。
* `enterAlwaysCollapsed`另一种enterAlways，但是只显示折叠后的高度。配合`minHeight`使用
##### 官方样例3

演示了在`CollapsingToolbarLayout`下的视差效果.
新出现了`app:layout_collapseMode="parallax"`属性就是开启视差.
`app:layout_collapseParallaxMultiplier="0.5"`是配合使用的,作用是设置开启视差切换的比例.这里0.5表示折叠到一半时开启切换