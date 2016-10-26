package cn.jestar.coodinatorlayoutdemo.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import cn.jestar.coodinatorlayoutdemo.AppConfig;
import cn.jestar.coodinatorlayoutdemo.R;
import cn.jestar.coodinatorlayoutdemo.view.AdapterFactory;

/**
 * 官方样例3扩展1
 * 实现常用的标题栏+轮播图+选择条+RecyclerView的折叠组合
 * Created by jestar on 16/10/13.
 */
public class OfficialSample3Ext1Activity extends BaseToolbarActivity{
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @Override
    protected void init() {
        super.init();
       initRecyclerView();
        initViewPager();
    }

    private void initViewPager() {
        String[] stringArray = getResources().getStringArray(R.array.tab_item);
        for (String s : stringArray) {
            mTabLayout.addTab(mTabLayout.newTab().setText(s));
        }
        mViewPager.setAdapter(AdapterFactory.getInstance().createPageAdapter(AppConfig.IMAGES,stringArray));
        mTabLayout.setupWithViewPager(mViewPager,true);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_official_sample2_ext1;
    }
}
