package cn.jestar.coodinatorlayoutdemo.view;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import cn.jestar.coodinatorlayoutdemo.R;

/**
 * Adapter工厂类
 * Created by jestar on 16/10/13.
 */
public class AdapterFactory {
    public List<String> mStringList = new ArrayList<>();

    private AdapterFactory() {
        initDate();
    }

    public static AdapterFactory getInstance() {
        return RecyclerAdapterHolder.mFactory;
    }

    private static class RecyclerAdapterHolder {
        public static AdapterFactory mFactory = new AdapterFactory();
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

    public PagerAdapter createPageAdapter(int[] imageRes, String[] stringArray) {
        return new CustomPageAdapter(imageRes,stringArray);
    }

    private void initDate() {
        for (int i = 0; i < 50; i++) {
            mStringList.add(String.format("测试数据%s", i));
        }
    }
   public class CustomPageAdapter extends PagerAdapter{

       private final int[] mImageRes;
       private final String[] mTitles;

       public CustomPageAdapter(int[] imageRes, String[] stringArray) {
           mImageRes = imageRes;
           mTitles = stringArray;
       }

       @Override
       public int getCount() {
           return mImageRes==null?0:mImageRes.length;
       }

       @Override
       public CharSequence getPageTitle(int position) {
           return mTitles[position];
       }

       @Override
       public boolean isViewFromObject(View view, Object object) {
           return object==view;
       }

       @Override
       public Object instantiateItem(ViewGroup container, int position) {
           ImageView imageView = new ImageView(container.getContext());
           container.addView(imageView);
           imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
           imageView.setImageResource(mImageRes[position]);
           return imageView;
       }

       @Override
       public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView((View) object);
       }
   }
    public class StringViewHolder extends RecyclerView.ViewHolder {
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
