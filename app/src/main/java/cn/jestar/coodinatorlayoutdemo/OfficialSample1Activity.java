package cn.jestar.coodinatorlayoutdemo;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;

/**
 * 官方样例1
 * Created by jestar on 16/10/13.
 */
public class OfficialSample1Activity extends BaseToolbarActivity {
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @Override
    protected void init() {
        super.init();
        initRecyclerView();
        initTab();
    }

    private void initTab() {
        mTabLayout.setTabTextColors(Color.WHITE,Color.RED);
        mTabLayout.setSelectedTabIndicatorColor(Color.RED);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 1; i < 4; i++) {
            String format = String.format("TAB%s", i);
            mTabLayout.addTab(mTabLayout.newTab().setText(format));
        }
    }

    private void initRecyclerView() {
        RecyclerView.Adapter<RecyclerAdapterFactory.StringViewHolder> adapter = RecyclerAdapterFactory.getInstance().createAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_official_sample1;
    }
}
