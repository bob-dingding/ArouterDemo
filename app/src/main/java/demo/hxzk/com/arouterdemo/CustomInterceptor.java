package demo.hxzk.com.arouterdemo;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;



/**
 * 作者：created by ${zjt} on 2019/3/26
 * 描述:自定义拦截器
 */
//priority属性是拦截器优先级，priority数值越小，越先执行，如果两个拦截器的优先级一样，项目编译就会报错
@Interceptor(priority = 2)
public class CustomInterceptor implements IInterceptor {
    private static final String TAG = "CustomInterceptor";


    Context mContext;



    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.e(TAG, "process: ");
        int extra = postcard.getExtra();
        switch (extra) {
            //拦截登录
            case ArouteConfig.STRATEGY:
                boolean isLogin =false;
                if (isLogin) {
                    callback.onContinue(postcard);
                } else {
                    callback.onInterrupt(new Exception("请先登录"));
                }
                break;
            //什么都不拦截
            default:
                callback.onContinue(postcard);
                break;
        }
    }

    @Override
    public void init(Context context) {
        this.mContext = context;
        Log.e(TAG, "init: ");
    }
}
