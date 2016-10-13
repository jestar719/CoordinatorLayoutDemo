package cn.jestar.coodinatorlayoutdemo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by jestar on 16/10/13.
 */
public class RecyclerAdapterFactory {
    public List<String> mStringList=new ArrayList<>();
    private RecyclerAdapterFactory() {
        initDate();
    }
    public static RecyclerAdapterFactory getInstance(){
        return RecyclerAdapterHolder.mFactory;
    }
    private static class RecyclerAdapterHolder{
        public static RecyclerAdapterFactory mFactory=new RecyclerAdapterFactory();
    }
    public RecyclerView.Adapter<StringViewHolder> createAdapter() {
        RecyclerView.Adapter<StringViewHolder> adapter = new RecyclerView.Adapter<StringViewHolder>() {
            @Override
            public StringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_menu, parent, false);
                return new StringViewHolder(view);
            }

            @Override
            public void onBindViewHolder(StringViewHolder holder, int position) {
                holder.setText(mStringList.get(position));
            }

            @Override
            public int getItemCount() {
                return mStringList.size();
            }
        };
        return adapter;
    }

    private void initDate() {
        for (int i = 0; i < 50; i++) {
            mStringList.add(String.format("测试数据%s",i));
        }
    }
    public class StringViewHolder extends RecyclerView.ViewHolder{
        private final TextView mView;

        public StringViewHolder(View itemView) {
            super(itemView);
            mView = ButterKnife.findById(itemView, R.id.tv_item);
        }

        public void setText(String s) {
            mView.setText(s);
        }
    }
}
