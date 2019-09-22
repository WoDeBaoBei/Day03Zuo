package xiangmu.jiyun.com.day03zuo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import xiangmu.jiyun.com.day03zuo.R;
import xiangmu.jiyun.com.day03zuo.adapter.Rcadapter;
import xiangmu.jiyun.com.day03zuo.bean.ListBean;
import xiangmu.jiyun.com.day03zuo.model.ModelImp;
import xiangmu.jiyun.com.day03zuo.present.PresenterImp;

public class MainActivity extends AppCompatActivity implements View{

    private RecyclerView main_rc;
    private ArrayList<ListBean.DatasBean> list;
    private Rcadapter rcadapter;

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
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        main_rc.setLayoutManager(manager);
        main_rc.addItemDecoration(new DividerItemDecoration(MainActivity.this,1));
        list = new ArrayList<>();
        rcadapter = new Rcadapter(list, MainActivity.this);
        main_rc.setAdapter(rcadapter);
        rcadapter.setLn(new Rcadapter.Loo() {
            @Override
            public void lo(android.view.View view, int postion) {
                ListBean.DatasBean bean = list.get(postion);
                list.remove(bean);

                rcadapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "取关了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSuccess(ListBean listBean) {
            list.addAll(listBean.getDatas());
            rcadapter.notifyDataSetChanged();
    }

    @Override
    public void onFile(String str) {

    }
}
