package demo.hxzk.com.arouterdemo;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;

/**
 * 作者：created by ${zjt} on 2019/3/26
 * 描述:自定义CustomNavigationCallBack，处理自己的逻辑
 */
public class CustomNavigationCallBack implements NavigationCallback {
    private static final String TAG = "CustomNavigationCallBac";

    Context mCOntext;

    public CustomNavigationCallBack(Context mCOntext) {
        this.mCOntext = mCOntext;
    }

    @Override
    public void onFound(Postcard postcard) {
        //路由目标被发现时调用
        Log.e(TAG, "onFound: ");
    }

    @Override
    public void onLost(Postcard postcard) {
        //路由被丢失时调用
        Log.e(TAG, "onLost: ");
    }

    @Override
    public void onArrival(Postcard postcard) {
     //路由到达之后调用
        Log.e(TAG, "onArrival: ");
    }

    @Override
    public void onInterrupt(final Postcard postcard) {
          //路由被拦截时调用
        //处理onInterrupt方法,被拦截的信息toast
        new Handler(mCOntext.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mCOntext, (String) postcard.getTag(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
