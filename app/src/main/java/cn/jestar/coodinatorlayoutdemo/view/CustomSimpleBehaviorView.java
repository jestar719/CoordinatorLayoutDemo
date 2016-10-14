package cn.jestar.coodinatorlayoutdemo.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.widget.TextView;

import cn.jestar.coodinatorlayoutdemo.CustomSimpleBehavior;

/**
 * 以注解的方式添加Behavior
 * Created by jestar on 16/10/14.
 */
@CoordinatorLayout.DefaultBehavior(CustomSimpleBehavior.class)
public class CustomSimpleBehaviorView extends TextView{
    public CustomSimpleBehaviorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
