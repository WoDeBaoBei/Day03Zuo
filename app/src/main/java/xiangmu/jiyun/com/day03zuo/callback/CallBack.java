package xiangmu.jiyun.com.day03zuo.callback;

import xiangmu.jiyun.com.day03zuo.bean.ListBean;

public interface CallBack {
    void onSuccess(ListBean listBean);
    void onFile(String str);
}
