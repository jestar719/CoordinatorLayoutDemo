### Demo说明
##### 官方样例1

`AppBarLayout`和其`Behavior`的基础应用.演示了怎么通过`layout_scrollFlags`和`Behavior`在xml中的使用.

##### 官方样例1扩展

演示了新出现属性`snap`的作用及不同的`layout_scrollFlags`组合的效果.

##### 官方样例2

演示了`CollapsingToolbarLayout`的基本使用.
新出现了`layout_scrollFlags`的新属性`exitUntilCollapsed`,`enterAlwaysCollapsed`及`app:layout_collapseMode`的配合效果
当折叠时,`layout_collapseMode`开始起作用.这里使用的是`pin`表示固定不动.
* `exitUntilCollapsed`拉的时候，这个View会跟着滑动直到折叠。
* `enterAlwaysCollapsed`另一种enterAlways，但是只显示折叠后的高度。配合`minHeight`使用
##### 官方样例3

演示了在`CollapsingToolbarLayout`下的视差效果.
新出现了`app:layout_collapseMode="parallax"`属性就是开启视差.
`app:layout_collapseParallaxMultiplier="0.5"`是配合使用的,作用是设置开启视差切换的比例.这里0.5表示折叠到一半时开启切换