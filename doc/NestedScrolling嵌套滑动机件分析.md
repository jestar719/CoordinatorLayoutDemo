#### 嵌套滑动机制`NestedScrolling`
嵌套滑动机制,是指在滑动一个可滑动`scrollAble`的组件时,同时让响应其滑动的其它组件也进行滑动,同时根据滑动的方向和距离动态改变自身及其它组件的尺寸.

嵌套滑动机制是对**触摸事件分发机制**的一个补充.原来在子组件获得处理触摸事件时,直到手指再次按下,期间父组件是无处理触摸事件的(使用事件拦截除外),

`NestedScrolling`是在安卓5.0之后提供的.放在`V4`包里.相关接口如下
* `NestedScrollingChild`
* `NestedScrollingParent`
* `NestedScrollingChildHelper`
* `NestedScrollingParentHelper`

在`21.0.0`版之后的`V7,V4`包中,`RecyclerView`,`SwipRefreshLayout`和`NestedScrollingView`默认实现了接口,支持`NestedScrolling`机制

另外还有ViewParentCompact`工具类提供一些方法,用与兼容性操作

* 嵌套滑动机制的原理

    * 在`Down`事件时子组件在开始滑动时寻找能处理嵌套滑动的父组件,并通知父组件开启滑动.
    * 在`Move`事件中,获取滑动距离,先通知父组件消费此次滑动.
    * 根据父组件消费掉的滑动距离及自身的偏移量计算自身可消费的滑动距离及自身并处理.
    * 通知父组件自身的消费量.
    * 在`Up`或`cancel`事件时通知父组件结束此次滑动
* 嵌套滑动机制的流程
    * `startNestedScrolling`

        开启嵌套滑动,由子View开启流程.寻找能接收`NestedScroll`的`parent`.通知其一起处理触摸事件.
        * 流程为 子组件`startNestedScrolling`->父组件`onStartNestedScroll`->父组件`onNestedScrollAccepted`
    * `dispatchNestedPreScroll`

        `public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow);`
       此方法在子View处理滑动之前调用.通知父组件的滑动距离.父组件对滑动先进行消费.

        两个数组传递给父组件.父组件把消费的scroll长度及子组件的偏移量记录在其中.
        由子组件进行处理.如果父组件消费了`scroll`,则返回true,否则为false
        * 流程为 子组件`dispatchNestedPreScroll`->父组件`dispatchNestedPreScroll`
    * `dispatchNestedScroll`

        `public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed,
                     int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow);`
       一般在子组件处理了`scroll`之后调用,向父组件汇报子组件消费及未消费的`scroll`长度
      如果父组件接受了参数并进行消费,则返回`true`,否则返回`false`
      * 流程为 子组件`dispatchNestedScroll`->父组件`onNestedScroll`
*   `stopNestedScroll`

       结束此次滑动事件.
       * 流程为 子组件`stopNestedScroll`->父组件`onStopNestedScroll`

整个流程中主要是子组件发起调用,父组件接受回调.

通常是子组件的`onTouchEvent`中子组件调用自身的`NestedScroll`相关方法.
在方法中使用`V4`包中`NestedScrollingChildHelper`工具类来调用父组件的相关回调
父组件使用`V4`包中的`NestedScrollingParentHelper`处理.