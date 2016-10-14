package cn.jestar.coodinatorlayoutdemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 自定义简单的Behavior.让child根据目标移动
 * Created by jestar on 16/10/14.
 */
public class CustomSimpleBehavior extends CoordinatorLayout.Behavior<TextView> {
    public CustomSimpleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        child.setX(dependency.getX());
        child.setY(dependency.getY()+200);
        return false;
    }
}
