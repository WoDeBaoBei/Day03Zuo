package xiangmu.jiyun.com.zuo2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import xiangmu.jiyun.com.zuo2.R;
import xiangmu.jiyun.com.zuo2.bean.ListBean;

public class Vpadapter extends PagerAdapter {

    ListBean.ResultsBean bean;
    private ArrayList<ListBean.ResultsBean> list;

    public Vpadapter(ListBean.ResultsBean bean, ArrayList<ListBean.ResultsBean> list) {
        this.bean = bean;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(container.getContext(), R.layout.vp_item, null);
        ImageView vp = view.findViewById(R.id.vp_vp);
        if (position==0){
           Glide.with(container.getContext()).load(bean.getUrl()).into(vp);
        }
        else {
            Glide.with(container.getContext( )).load(list.get(position).getUrl()).into(vp);
        }
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
