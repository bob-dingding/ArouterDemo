package demo.hxzk.com.arouterdemo;

import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 作者：created by ${zjt} on 2019/3/26
 * 描述:
 */
public class BaseApplication extends Application {

    //  ARouter 调试开关
    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugARouter) {
            // 打印日志
            ARouter.openLog();
            //开始调试线上版本需要关闭,否则有安全风险
            ARouter.openDebug();
        }
        ARouter.init(BaseApplication.this);
    }




    //此方法只会在模拟器调用是个鸡肋
    @Override
    public void onTerminate() {
        super.onTerminate();
        //释放Arouter资源的代码
       ARouter.getInstance().destroy();
    }
}
