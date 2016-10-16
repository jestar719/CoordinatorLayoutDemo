package cn.jestar.coodinatorlayoutdemo.activity;

import android.view.MotionEvent;
import android.view.View;

import butterknife.OnTouch;
import cn.jestar.coodinatorlayoutdemo.R;

/**
 * 自定义简单的Behavior演示
 * 演示了在View上使用注解添加Behavior
 * 演示了Behavior的一对多的关系
 * Created by jestar on 16/10/14.
 */

public class CustomSimpleBehavior1Activity extends BaseCustomTitleActivity {

    @OnTouch({R.id.tv_dependency_a,R.id.tv_dependency_b})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
            view.setX(motionEvent.getRawX() - view.getWidth() / 2);
            view.setY(motionEvent.getRawY() - view.getHeight() / 2);
        }
        return false;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_simple_behavior1;
    }
}
