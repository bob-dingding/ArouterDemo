package demo.hxzk.com.arouterdemo;

import android.content.Intent;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * 作者：created by ${zjt} on 2019/3/26
 * 描述:
 */

@Route(path = Constance.TEST_TWO_ACTIVITY , group = Constance.GROUP)
public class SameModuleTwoActivity extends BaseActivity {


    @Override
    public int setLayoutId() {
        return R.layout.activity_testtwo;
    }

    @Override
    public void ininView() {

    }

    @Override
    public void ininData() {

    }

    @Override
    public void ininEvent() {
        setResult(Constance.RESPONSECODE);
        finish();

    }


}
