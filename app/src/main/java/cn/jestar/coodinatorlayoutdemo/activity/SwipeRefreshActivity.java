package cn.jestar.coodinatorlayoutdemo.activity;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;

import butterknife.BindView;
import cn.jestar.coodinatorlayoutdemo.R;

/**
 * 官方样例1
 * Created by jestar on 16/10/13.
 */
public class SwipeRefreshActivity extends BaseToolbarActivity {
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppBar;

    @Override
    protected void init() {
        super.init();
        initSwipeRefresh();
        initRecyclerView();
        initTab();
    }

    private void initSwipeRefresh() {
        mSwipeRefresh.setRefreshing(true);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefresh.setRefreshing(false);
            }
        });
        mSwipeRefresh.setProgressViewOffset(true, -20, 100);
        mAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                mSwipeRefresh.setEnabled(verticalOffset >= 0);
            }
        });
    }

    private void initTab() {
        mTabLayout.setTabTextColors(Color.WHITE, Color.RED);
        mTabLayout.setSelectedTabIndicatorColor(Color.RED);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 1; i < 4; i++) {
            String format = String.format("TAB%s", i);
            mTabLayout.addTab(mTabLayout.newTab().setText(format));
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_swipe_refresh;
    }
}
