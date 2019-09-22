package xiangmu.jiyun.com.day03zuo.api;


import io.reactivex.Observable;
import retrofit2.http.GET;
import xiangmu.jiyun.com.day03zuo.bean.ListBean;

public interface Myservice {
    public String mUrl="http://static.owspace.com/";
    @GET("?c=api&a=getList&page_id=0")
    Observable<ListBean> getList();
}
