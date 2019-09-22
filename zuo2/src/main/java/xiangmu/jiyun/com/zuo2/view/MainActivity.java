package xiangmu.jiyun.com.zuo2.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import java.util.ArrayList;

import xiangmu.jiyun.com.zuo2.R;
import xiangmu.jiyun.com.zuo2.adapter.Rcadapter;
import xiangmu.jiyun.com.zuo2.adapter.Vpadapter;
import xiangmu.jiyun.com.zuo2.bean.ListBean;
import xiangmu.jiyun.com.zuo2.model.ModelImp;
import xiangmu.jiyun.com.zuo2.present.PresenterImp;

public class MainActivity extends AppCompatActivity implements View {

    private RecyclerView main_rc;
    private ArrayList<ListBean.ResultsBean> list;
    private Rcadapter adapter;
    private ViewPager main_vp;
    private TextView main_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        PresenterImp imp = new PresenterImp(new ModelImp(), this);
        imp.getData();
    }

    private void initView() {
        main_rc = (RecyclerView) findViewById(R.id.main_rc);
        main_vp = (ViewPager) findViewById(R.id.main_vp);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        main_rc.setLayoutManager(manager);
        list = new ArrayList<>();
        adapter = new Rcadapter(list, MainActivity.this);
        main_rc.setAdapter(adapter);
        adapter.setLn(new Rcadapter.Loo() {
            private Vpadapter vpadapter;

            @Override
            public void lo(android.view.View view, int postion) {
                //Toast.makeText(MainActivity.this, "你点击了此图片", Toast.LENGTH_SHORT).show();
                ListBean.ResultsBean bean = list.get(postion);
                vpadapter = new Vpadapter(bean, list);
                main_vp.setAdapter(vpadapter);
                main_vp.setVisibility(android.view.View.VISIBLE);

                main_rc.setVisibility(android.view.View.INVISIBLE);
                nmb(1,list.size());
                main_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        nmb(position+1,list.size());
                    }

                    @Override
                    public void onPageSelected(int position) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        });


        main_tv = (TextView) findViewById(R.id.main_tv);

    }

    private void nmb(int b, int v) {
main_tv.setText("第"+b+"张/共"+v+"张");
    }

    ;

    @Override
    public void onSuccess(ListBean listBean) {
        list.addAll(listBean.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFile(String str) {

    }
}
