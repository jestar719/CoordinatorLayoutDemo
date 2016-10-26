package cn.jestar.coodinatorlayoutdemo.activity;

import cn.jestar.coodinatorlayoutdemo.R;

/**
 * 官方样例3,视差模式
 * Created by jestar on 16/10/13.
 */
public class OfficialSample3Activity extends BaseToolbarActivity{
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
