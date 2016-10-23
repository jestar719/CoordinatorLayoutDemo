package cn.jestar.coodinatorlayoutdemo.activity;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jestar.coodinatorlayoutdemo.R;

/**
 * 用与演示BottomSheet和BottomSheetDialog的页面
 * Created by jestar on 16/10/19.
 */
public class BottomSheetActivity extends BaseCustomTitleActivity {
    @BindView(R.id.bottomSheetContainer)
    View mBottomSheetView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mRefreshLayout;
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
            mBottomSheetDialog.setContentView(R.layout.layout_bottom_sheet);
        }
        mBottomSheetDialog.show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bottom_sheet;
    }
}
