### Demo说明
#### 官方样例1及扩展
`AppBarLayout`和其`Behavior`的基础应用.演示了怎么通过`layout_scrollFlags`和`Behavior`在xml中的使用.
基本结构如下

````
<CoordinatorLayout>
    <AppBarLayout>

        <View
        ...
        app:layout_scrollFlags="xxx"/>

        <View
            ...
            app:layout_scrollFlags="xxx"/>

     </AppBarLayout>

</CoordinatorLayout>
````
在扩展中演示了不同的`layout_scrollFlags`组合的效果.

使用说明
* `layout_scrollFlags`的属性说明,可以通过`|`符号来组合多个属性
    *  `scroll`,滑动的基础,必须放在第一位.有此属性才能响应滑动
    *  `snap`为滑动增加弹性效果,在放手时全显示/全不显示
    * `enterAlwyas` 只要向下滑动就显示,向上滑动就隐藏
* `AppBarLayout`的滑动是从上至下的遍历子组件,直到遇到没有`scroll`属性的子组件.其后其它子组件无论有无`scroll`属性都视为无
* `layout_scrollFlags`只对AppBarLayout的直接子组件有效.
* 使用`include`导入的组件,除非原布局文件中根节点中含有`layout_scrollFlags`,否则视为无此属性.在`include`上添加无效

````
<include
        layout="@layout:xxxxx"
        app:layout_scrollFlags="xxx"/>
````
这样是无效的

如果想使用`include`可以使用`Framlayout`等布局,设置`layout_scrollFlags`,然后包裹它.如

````
    <FrameLayout
        ...
        app:layout_scrollFlags="xxx"">

        <include layout="@layout:xxxxx"/>

     </FrameLayout>
````

#### 官方样例2及扩展

演示了`CollapsingToolbarLayout`的基本使用.
及`layout_scrollFlags`的属性`exitUntiCollapsed`,`enterAlwaysCollapsed`及`app:layout_collapseMode`的配合效果
* `layout_scrollFlags`中配合折叠效果的属性
    * `exitUntilCollapsed` 向上滑动时,View会向上滑动并折叠.此时`pin`属性才能产生效果,从下向上折叠到含有`pin`属性的子组件为止.
                                        当依赖的组件向下滑动并且已经滑动到顶时,View会向下展开.
    * `enterAlwaysCollapsed` 单独使用时等同与`enterAlways`,`layout_collapseMode`属性不起作用.
                                            与`enterAlways`一起配合使用时,只要向下滑动就会展开`minHeight`部分.
                                            当依赖的组件向下滑动并且已经滑动到顶时,View会向下展开.
                                            推荐使用`scroll|enterAlways|enterAlwaysCollapsed|snap`

`layout_collapseMode`开始的作用.
    *   `pin`表示固定不动,只在`exitUntilCollapsed`时有效
    *   `parallax`表示开启视差效果(折叠速度比滑动速度慢)
        *    `app:layout_collapseParallaxMultiplier`是配合视差效果使用的,作用是设置视差的比例.默认是0.5.数值越大视差越大
在`CollapsingToolbarLayout`中有几个属性是配合`Toolbar`的
* ` app:contentScrim` 设置当折叠时`Toolbar`的背景,如果没有这个属性,则会显示视差的背景
* `app:titleEnabled` 设置标题是否根随滑动而变化,默认是开启的

