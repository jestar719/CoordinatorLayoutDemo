package cn.jestar.coodinatorlayoutdemo.activity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import cn.jestar.coodinatorlayoutdemo.R;

/**
 * 自定义简单的Behavior演示
 * Created by jestar on 16/10/14.
 */

public class CustomSimpleBehavior1Activity extends BaseCustomTitleActivity {
    @BindView(R.id.tv_dependency)
    TextView mTvDependency;

    @Override
    protected void init() {
        mTvDependency.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    view.setX(motionEvent.getRawX() - view.getWidth() / 2);
                    view.setY(motionEvent.getRawY() - view.getHeight() / 2);
                }
                return false;
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_simple_behavior1;
    }
}
