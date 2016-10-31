package cn.jestar.coodinatorlayoutdemo.activity;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jestar.coodinatorlayoutdemo.R;
import cn.jestar.coodinatorlayoutdemo.view.AdapterFactory;

/**
 * 用与演示BottomSheet和BottomSheetDialog的页面
 * Created by jestar on 16/10/19.
 */
public class BottomSheetActivity extends BaseCustomTitleActivity {
    @BindView(R.id.bottomSheetContainer)
    View mBottomSheetView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.bottom_recycler)
    RecyclerView mBottomRecycler;
    private BottomSheetBehavior<View> mBehavior;
    private BottomSheetDialog mBottomSheetDialog;

    @Override
    protected void init() {
        mBehavior = BottomSheetBehavior.from(mBottomSheetView);
        mBehavior.setHideable(true);
        mBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        initRecyclerView();
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefreshLayout.setRefreshing(false);
            }
        });
        initBottomRecycler();
    }

    private void initBottomRecycler() {
        RecyclerView.Adapter<AdapterFactory.StringViewHolder> adapter = AdapterFactory.getInstance().createAdapter();
        mBottomRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mBottomRecycler.setAdapter(adapter);
    }

    @OnClick(R.id.btn_bottomSheet)
    public void onShowBottomSheet() {
        int state = mBehavior.getState();
        state = state == BottomSheetBehavior.STATE_EXPANDED ? BottomSheetBehavior.STATE_HIDDEN : BottomSheetBehavior.STATE_EXPANDED;
        mBehavior.setState(state);
    }

    @OnClick(R.id.btn_bottomSheetDialog)
    public void onShowBottomSheetDialog() {
        if (mBottomSheetDialog == null) {
            mBottomSheetDialog = new BottomSheetDialog(this);
            View view = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet, null);
            mBottomSheetDialog.setContentView(view);
        }
        mBottomSheetDialog.show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bottom_sheet;
    }
}
