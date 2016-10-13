package cn.jestar.coodinatorlayoutdemo;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;

public class MainActivity extends BaseCustomTitleActivity {

    @BindView(R.id.lv_menu)
    ListView mLvMenu;
    private String[] mStringArray;

    @Override
    protected void init() {
        mStringArray = getResources().getStringArray(R.array.main_menu);
        ArrayAdapter<String> mStringArrayAdapter = new ArrayAdapter<>(this, R.layout.item_main_menu, R.id.tv_item, mStringArray);
        mLvMenu.setAdapter(mStringArrayAdapter);
        mLvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                jumpToOther(i);
            }
        });
    }

    private void jumpToOther(int index) {
        String s = mStringArray[index];
        Class<? extends BaseActivity> activity = AppConfig.ACTIVITYS[index];
        Intent intent = new Intent(this, activity);
        intent.putExtra(TAG,s);
        startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
