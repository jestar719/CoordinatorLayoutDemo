package cn.jestar.coodinatorlayoutdemo;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;

import butterknife.BindView;

/**
 * 官方样例3,视差模式
 * Created by jestar on 16/10/13.
 */
public class OfficialSample3ExtActivity extends BaseToolbarActivity{
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.collapsing_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @Override
    protected void init() {
        super.init();
       initRecyclerView();
        initTab();
    }

    private void initTab() {
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.exit_unit_collapsed));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.enter_unit_collapsed));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                boolean isExit = tab.getPosition() == 0;
                int flag=isExit? AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED: AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED;
                AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) mCollapsingToolbarLayout.getLayoutParams();
                layoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL|flag);
                mCollapsingToolbarLayout.setLayoutParams(layoutParams);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_official_sample3_ext;
    }
}
