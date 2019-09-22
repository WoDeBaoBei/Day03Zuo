package xiangmu.jiyun.com.zuo2.callback;


import xiangmu.jiyun.com.zuo2.bean.ListBean;

public interface CallBack {
    void onSuccess(ListBean listBean);
    void onFile(String str);
}
