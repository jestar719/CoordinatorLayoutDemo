package cn.jestar.coodinatorlayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import butterknife.ButterKnife;

/**
 * Created by jestar on 16/10/13.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected static final String TAG = "tag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(TAG);
            if (!TextUtils.isEmpty(stringExtra)) {
                setTitleText(stringExtra);
            }
        }
        init();
    }

    protected abstract void setTitleText(String stringExtra);

    protected abstract void init();

    @LayoutRes
    abstract protected int getLayoutId();

}
