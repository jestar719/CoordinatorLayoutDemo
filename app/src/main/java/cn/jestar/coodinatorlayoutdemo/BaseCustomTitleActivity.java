package cn.jestar.coodinatorlayoutdemo;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 自定义标题栏的基类
 * Created by jestar on 16/10/13.
 */
public abstract class BaseCustomTitleActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Override
    protected void setTitleText(String stringExtra) {
        mTvTitle.setText(stringExtra);
    }

    @OnClick(R.id.iv_back)
    public void onBack() {
        finish();
    }
}
