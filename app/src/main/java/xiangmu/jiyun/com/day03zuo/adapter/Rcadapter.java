package xiangmu.jiyun.com.day03zuo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import xiangmu.jiyun.com.day03zuo.R;
import xiangmu.jiyun.com.day03zuo.bean.ListBean;

public class Rcadapter extends RecyclerView.Adapter<Rcadapter.ViewHolder> {
 private ArrayList<ListBean.DatasBean> list;
 private Context context;

    public Rcadapter(ArrayList<ListBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.rc_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ListBean.DatasBean bean = list.get(position);
        final ViewHolder viewHolder=holder;
        viewHolder.rc_tv1.setText(bean.getTitle());
        viewHolder.rc_tv2.setText(bean.getName());
        Glide.with(context).load(bean.getThumbnail())
                .apply(RequestOptions.bitmapTransform(new CenterCrop()))
                .into(viewHolder.rc_iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ln.lo(v,position);
            }
        });
        viewHolder.rc_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = viewHolder.rc_bt.getText().toString();
                if (s.equals("关注")){
                    viewHolder.rc_bt.setText("取消");
                    Toast.makeText(context, "你关注了对方", Toast.LENGTH_SHORT).show();
                }
                if (s.equals("取消")){
                    viewHolder.rc_bt.setText("关注");
                    Toast.makeText(context, "取消关注", Toast.LENGTH_SHORT).show();
                    list.remove(bean.getTitle()+bean.getName());

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView rc_iv;
        TextView rc_tv1;
        TextView rc_tv2;
        Button rc_bt;
        public ViewHolder(View itemView) {
            super(itemView);
            rc_iv=itemView.findViewById(R.id.rc_iv);
            rc_tv1=itemView.findViewById(R.id.rc_tv1);
            rc_tv2=itemView.findViewById(R.id.rc_tv2);
            rc_bt=itemView.findViewById(R.id.rc_bt);

        }
    }
    private Loo ln;

    public void setLn(Loo ln) {
        this.ln = ln;
    }

    public interface Loo{
        void lo(View view,int postion);
    }
}
