package cn.jestar.coodinatorlayoutdemo.activity;

import cn.jestar.coodinatorlayoutdemo.R;

/**
 * 官方样例2,CollapsingToolbarLayout的初步使用
 * Created by jestar on 16/10/13.
 */
public class OfficialSample2Activity  extends BaseToolbarActivity{
    @Override
    protected void init() {
        super.init();
       initRecyclerView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_official_sample2;
    }
}
