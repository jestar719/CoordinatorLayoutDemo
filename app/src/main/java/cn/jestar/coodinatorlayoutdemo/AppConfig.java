package cn.jestar.coodinatorlayoutdemo;

/**
 * Created by jestar on 16/10/13.
 */
public interface AppConfig {
    Class<? extends BaseActivity>[] ACTIVITYS = new Class[]{
            OfficialSample1Activity.class,
            OfficialSample1ExtActivity.class,
            OfficialSample2Activity.class,
            OfficialSample3Activity.class
    };
}
