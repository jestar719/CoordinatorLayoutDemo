package cn.jestar.coodinatorlayoutdemo;

import cn.jestar.coodinatorlayoutdemo.activity.BaseActivity;
import cn.jestar.coodinatorlayoutdemo.activity.CustomSimpleBehavior1Activity;
import cn.jestar.coodinatorlayoutdemo.activity.CustomSimpleBehaviorActivity;
import cn.jestar.coodinatorlayoutdemo.activity.OfficialSample1Activity;
import cn.jestar.coodinatorlayoutdemo.activity.OfficialSample1ExtActivity;
import cn.jestar.coodinatorlayoutdemo.activity.OfficialSample2Activity;
import cn.jestar.coodinatorlayoutdemo.activity.OfficialSample3Activity;
import cn.jestar.coodinatorlayoutdemo.activity.OfficialSample3Ext1Activity;
import cn.jestar.coodinatorlayoutdemo.activity.CustomCollapsingToCenterActivity;
import cn.jestar.coodinatorlayoutdemo.activity.OfficialSample3ExtActivity;

/**
 * 常量
 * Created by jestar on 16/10/13.
 */
public interface AppConfig {
    Class<? extends BaseActivity>[] ACTIVITYS = new Class[]{
            OfficialSample1Activity.class,
            OfficialSample1ExtActivity.class,
            OfficialSample2Activity.class,
            OfficialSample3Activity.class,
            OfficialSample3ExtActivity.class,
            OfficialSample3Ext1Activity.class,
            CustomCollapsingToCenterActivity.class,
            CustomSimpleBehaviorActivity.class,
            CustomSimpleBehavior1Activity.class
    };
    int[] IMAGES = {R.drawable.meinu,R.drawable.meinu,R.drawable.meinu};
}
