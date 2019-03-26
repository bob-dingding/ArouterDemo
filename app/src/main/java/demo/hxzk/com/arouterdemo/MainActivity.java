package demo.hxzk.com.arouterdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

//path为跳转的路由路径,需要注意的是路径至少需要有两级，如：/xx/xx;extras 为拦截策略
@Route(path = "/app/main")
public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    Button btn, btnTwo;


    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void ininView() {
        btn = findViewById(R.id.button);
        btnTwo = findViewById(R.id.buttonintent);
    }

    @Override
    public void ininData() {

    }

    @Override
    public void ininEvent() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ARouter.getInstance().build("/app/samemoduleactivity").navigation();
                //也可以使用URI直接跳转
               // Uri uri = Uri.parse("/app/samemoduleactivity");
               // ARouter.getInstance().build(uri).navigation();
                //Fragment的跳转也是先添加注解然后强转
                //Fragment fragment = (Fragment) ARouter.getInstance().build(Constance.ACTIVITY_URL_FRAGMENT).navigation();
                String mpath = "/app/samemoduleactivity";
                Bundle mBundle = new Bundle();
                mBundle.putString("str", "String");
                toActivityAndBundle(MainActivity.this, mpath, mBundle);

            }
        });



        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(Constance.TEST_TWO_ACTIVITY,Constance.GROUP).navigation(MainActivity.this,Constance.REQUESTCODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case Constance.RESPONSECODE:
                Log.e(TAG, "onActivityResult:接收到返回的数据 ");
                break;
        }
    }
}