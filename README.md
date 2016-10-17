# CoordinatorLayout的演示Demo

项目中需要相关效果,然后记得`Design`库提供了相关组件.

在网上找到了很多样例和讲解.但是网上找的都只是一部分.各有偏重点.但没有一个从基础原理上完完整整的讲解

只能自己对照源码去一步步的分析.以期完全掌握其动作原理,流程等.

于是有了这个Demo.从浅到深用一个个的案例去演示不同的用法.

做了几天,发现坑被自己越挖越大,只能慢慢填了

### 新手上路
#### 一 `CoordinatorLayout`干什么用的
用来谐调两个子组件之间的互动改变.比如滑动,缩放.等等.目前官方推出的配套的其它组件主要集中在滑动互动上.
#### 二 怎么做到的
一个重要的新角色`Behavior`出场,`CoordinatorLayout`做为一个桥梁,来配对相关联的两个子组件,设置到对应的`Behavior`里

由Behavior代理子组件的相关事件,比如`onMeasure,onLayout,onTouchEvent`等

#### 三 怎么配对的
`Behavior`是一种基与观察者模式的控制器.其中被观察的`View`叫`DependencyView`,配对的`View`叫`ChildView`.

`Behavior`是承继自`CoordinatorLayout.Behaviro<T extends View>`.其中的泛型用来确定`ChildView`的类型.

`Behavior`中`layoutDependsOn`方法用来判断一个`View`是否为`DependencyView`

`CoordinatorLayout`在每轮触摸事件或子组件发生改变时,获取该子组件的`Behavior`,遍历子组件,寻找对应的`ChildView`并完成配对
#### 四 Behavior是怎么设置的
`Behavior`是存放在`CoordinatorLayout.LayoutParams`里的.`CoordinatorLayout`的直接子组件的`LayoutParams`都是.

`Behavior`有三种设置方式
* 在`xml`中使用`app:scrolling_flags`来设置
* 在组件类声明上使用注解`@Coordinator.DefaultBehavior(T.class)`来设置
* 在代码中创建实例,设置到`Coodinator.LayoutParams`中

#### 五 有哪些配套的`View`和`Behavior`
* `AppBarLayout`及其`AppBarLayout.Behavior`,其`ChildView`为`AppBarLayout`,`Dependency`为`View`
* `CollapsingToolbarLayout`,配合`AppBarLayout`使用,生成折叠及视差模式
* `FloatingActionButton`及其`FloatingActionButton.Behavior`, 其`ChildView`为`FloatingActionButton`,`Dependency`为`View`
* `BottomSheetBehavior`,`Dependency`为`View`,因为泛型为`View`所以需要在代码中使用.定义好`ChildView`的类型.
默认提供`BottomSheetDialog`,`BottomSheetFragment`的实现.
* `SwipeDismissBehavior`, `Dependency`为`View`,因为泛型为`View`,所以需要在代码中使用.定义好`ChildView`的类型.
在`SnakeBar`中有个其子类`SnakeBar.Behavior<SnakeBar>`

通常使用得最多的是`AppbarLayout`和`CollapsingToolbarLayout`

#### 六 具体的使用方法
[看Demo及对应的说明](doc/Demo案例说明.md)


#### 相关知识点分析
* [`NestedScrolling嵌套滑动机件分析`](NestedScrolling嵌套滑动机件分析.md)
* [`CoordinatorLayout相关分析`](doc/CoordinatorLayout分析.md)
* [`Behavior分析`](doc/Behavior分析.md)
* [`官方配套的View分析`](doc/官方配套的View分析.md)







