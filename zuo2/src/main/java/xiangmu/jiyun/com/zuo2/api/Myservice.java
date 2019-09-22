package xiangmu.jiyun.com.zuo2.api;


import io.reactivex.Observable;
import retrofit2.http.GET;
import xiangmu.jiyun.com.zuo2.bean.ListBean;

public interface Myservice {
    //http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
    public String mUrl="http://gank.io/api/data/";
    @GET("%E7%A6%8F%E5%88%A9/20/1")
    Observable<ListBean> getList();
}
