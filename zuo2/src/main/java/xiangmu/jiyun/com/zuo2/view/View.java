package xiangmu.jiyun.com.zuo2.view;


import xiangmu.jiyun.com.zuo2.bean.ListBean;

public interface View {
    void onSuccess(ListBean listBean);
    void onFile(String str);
}
