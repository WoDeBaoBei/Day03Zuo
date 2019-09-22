package xiangmu.jiyun.com.day03zuo.present;

import xiangmu.jiyun.com.day03zuo.bean.ListBean;
import xiangmu.jiyun.com.day03zuo.callback.CallBack;
import xiangmu.jiyun.com.day03zuo.model.Model;
import xiangmu.jiyun.com.day03zuo.view.View;

public class PresenterImp implements Presenter,CallBack {
 private Model model;
 private View view;

    public PresenterImp(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void getData() {
        model.getData(this);
    }

    @Override
    public void onSuccess(ListBean listBean) {
        view.onSuccess(listBean);
    }

    @Override
    public void onFile(String str) {
        view.onFile(str);
    }
}
