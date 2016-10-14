package cn.jestar.coodinatorlayoutdemo;

import android.support.annotation.CallSuper;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;

/**
 * 官方样例演示1
 *使用了AppBarLayout与RecyclerView来互动
 * Created by jestar on 16/10/13.
 */
public abstract class BaseToolbarActivity extends BaseActivity {
    @BindView(R.id.tool_bar)
    Toolbar mToolbar;

    @Override
    protected void setTitleText(String stringExtra) {
        mToolbar.setTitle(stringExtra);
    }

    @CallSuper
    @Override
    protected void init() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
