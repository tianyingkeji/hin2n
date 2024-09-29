package wang.switchy.hin2n.activity;

import android.os.Bundle;

import wang.switchy.hin2n.R;
import wang.switchy.hin2n.template.BaseTemplate;
import wang.switchy.hin2n.template.CommonTitleTemplate;

public class CameraControlActivity extends BaseActivity {
    static {
        System.loadLibrary("ffmpegNdkCustom");
    }
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

    /**
     * 在 ffmpegNdkCustom.so 库中声明的原生c++的native方法，起连接作用
     */
    public native String stringFromJNI();
    public native String getConfiguration();
}
