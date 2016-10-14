package cn.jestar.coodinatorlayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 基类
 * Created by jestar on 16/10/13.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected static final String TAG = "tag";
    @Nullable
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
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

    /**
     * 初始化RecyclerView
     */
    protected void initRecyclerView() {
        RecyclerView.Adapter<RecyclerAdapterFactory.StringViewHolder> adapter = RecyclerAdapterFactory.getInstance().createAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(adapter);
    }
}
