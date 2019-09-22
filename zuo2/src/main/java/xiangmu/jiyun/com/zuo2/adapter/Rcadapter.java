package xiangmu.jiyun.com.zuo2.adapter;

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

import xiangmu.jiyun.com.zuo2.R;
import xiangmu.jiyun.com.zuo2.bean.ListBean;
public class Rcadapter extends RecyclerView.Adapter<Rcadapter.ViewHolder> {
 private ArrayList<ListBean.ResultsBean> list;
 private Context context;

    public Rcadapter(ArrayList<ListBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.rc_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ListBean.ResultsBean bean = list.get(position);
        ViewHolder viewHolder=holder;
        Glide.with(context).load(bean.getUrl()).into(viewHolder.rc_iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ln.lo(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView rc_iv;

        Button rc_bt;
        public ViewHolder(View itemView) {
            super(itemView);
            rc_iv=itemView.findViewById(R.id.rc_iv);
        }
    }
    private Loo ln;

    public void setLn(Loo ln) {
        this.ln = ln;
    }

    public interface Loo{
        void lo(View view, int postion);
    }
}
