package cn.jestar.coodinatorlayoutdemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;

/**
 * 官方样例1扩展
 * 从上至下分别title,text1,tab1,text2,text3,tab2.演示了不同的scroll_flag的组合.
 * title和text1的差别在与snap.snap增加了弹性拉动效果
 *tab1演示了enterAlways的效果.只要向下滑动就自动显示,自带snap效果
 * tab2演示了没有scroll_flag属性的组合在滑动时不会有任何变化.
 * include的组件.如果在原xml里没有scroll_flag属性,在include中添加无效.
 * Created by jestar on 16/10/13.
 */
public class OfficialSample1ExtActivity extends BaseCustomTitleActivity {
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    @Override
    protected void init() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView.Adapter<RecyclerAdapterFactory.StringViewHolder> adapter = RecyclerAdapterFactory.getInstance().createAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_official_sample1_ext;
    }
}
