package xiangmu.jiyun.com.day03zuo.view;

import xiangmu.jiyun.com.day03zuo.bean.ListBean;

public interface View {
    void onSuccess(ListBean listBean);
    void onFile(String str);
}
