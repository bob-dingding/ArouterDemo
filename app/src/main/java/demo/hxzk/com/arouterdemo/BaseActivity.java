package demo.hxzk.com.arouterdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 作者：created by ${zjt} on 2019/3/26
 * 描述:
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if( setLayoutId() != 0){
           setContentView(setLayoutId());
            //Activity或Fragmen进行路由注入
            ARouter.getInstance().inject(this);
        }
        ininView();
        ininData();
        ininEvent();
    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        ARouter.getInstance().destroy();
//    }

    public abstract int setLayoutId();
    public abstract void ininView();
    public abstract void ininData();
    public abstract void ininEvent();


    /**
     * 不带参数跳转
     * @param context
     * @param path
     */
    public static void toActivity(final Context context, String path) {
        ARouter.getInstance().build(path).navigation(context, new CustomNavigationCallBack(context));
    }

    /**
     * 带参数跳转
     * @param context
     * @param path
     * @param bundle
     */
    public static void toActivityAndBundle(final Context context, String path, Bundle bundle) {
        ARouter.getInstance().build(path)
                .withBundle("data", bundle)
                //.withTransition(),里面传入两个动画即可（R.anim.xxx）
                .navigation(context, new CustomNavigationCallBack(context));
    }


}
