package wang.switchy.hin2n.activity;

import android.os.Bundle;

import wang.switchy.hin2n.R;
import wang.switchy.hin2n.template.BaseTemplate;
import wang.switchy.hin2n.template.CommonTitleTemplate;

public class CameraControlActivity extends BaseActivity {

    @Override
    protected BaseTemplate createTemplate() {
        CommonTitleTemplate titleTemplate = new CommonTitleTemplate(this, getString(R.string.app_name));
        return titleTemplate;
    }

    @Override
    protected void doOnCreate(Bundle savedInstanceState) {

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_camera_ontrol;
    }
}
