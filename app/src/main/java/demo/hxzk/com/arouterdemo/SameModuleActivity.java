package demo.hxzk.com.arouterdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;


/**
 * 作者：created by ${zjt} on 2019/3/26
 * 描述:
 */

@Route(path = "/app/samemoduleactivity",extras = ArouteConfig.STRATEGY)
public class SameModuleActivity extends BaseActivity {

    //目标界面接受传递过来的值需要使用Autowired注解
    @Autowired(name = "data")
    Bundle mBundle;

    TextView mTv;

    @Override
    public int setLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void ininView() {
        mTv=findViewById(R.id.textView);
    }

    @Override
    public void ininData() {
      if(mBundle != null){
         String str= mBundle.getString("str") ;
          mTv.setText(str);
      }
    }

    @Override
    public void ininEvent() {

    }



}
