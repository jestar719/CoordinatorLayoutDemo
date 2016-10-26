package cn.jestar.coodinatorlayoutdemo.activity;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import cn.jestar.coodinatorlayoutdemo.R;

/**
 * 官方样例3扩展
 * 切换layout_scrollFlags,演示exitUnitCollapsed和enterAlwaysCollapsed的不同
 * Created by jestar on 16/10/13.
 */
public class OfficialSample3ExtActivity extends BaseToolbarActivity {
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.collapsing_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.seekBar)
    AppCompatSeekBar mSeekBar;
    @BindView(R.id.tv_collapseParallaxMultiplier_num)
    TextView mTvParallaxMultiperNum;
    final int[] mParams = new int[]{
            AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED,
            AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED,
            AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED
    };

    @Override
    protected void init() {
        super.init();
        initRecyclerView();
        initTab();
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                View parent = (View) seekBar.getParent().getParent();
                CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) parent.getLayoutParams();
                float multiplier = progress / 100f;
                layoutParams.setParallaxMultiplier(multiplier);
                parent.setLayoutParams(layoutParams);
                mTvParallaxMultiperNum.setText(String.valueOf(multiplier));
            }
        });
    }

    private void initTab() {
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.exit_unit_collapsed));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.enter_unit_collapsed));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.enter_always_collapsed));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) mCollapsingToolbarLayout.getLayoutParams();
                layoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | mParams[tab.getPosition()]);
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

    @OnCheckedChanged(R.id.tb_titleEnable)
    public void onSetTitleEnableChanged(boolean enable) {
        mCollapsingToolbarLayout.setTitleEnabled(enable);
    }

    @OnCheckedChanged(R.id.tb_contentScrim)
    public void onSetContentScrimChanged(boolean enable) {
        int color = enable ? getResources().getColor(R.color.colorPrimary) : Color.TRANSPARENT;
        mCollapsingToolbarLayout.setContentScrimColor(color);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_official_sample2_ext;
    }
}
