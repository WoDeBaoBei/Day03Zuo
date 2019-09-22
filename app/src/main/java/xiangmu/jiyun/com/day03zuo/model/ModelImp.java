package xiangmu.jiyun.com.day03zuo.model;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import xiangmu.jiyun.com.day03zuo.api.Myservice;
import xiangmu.jiyun.com.day03zuo.bean.ListBean;
import xiangmu.jiyun.com.day03zuo.callback.CallBack;

public class ModelImp implements Model{
    @Override
    public void getData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Myservice.mUrl)
                .build();
        Myservice myservice = retrofit.create(Myservice.class);
        Observable<ListBean> observable = myservice.getList();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListBean listBean) {
                        callBack.onSuccess(listBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            callBack.onFile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
