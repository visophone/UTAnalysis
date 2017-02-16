package cn.utsoft.commons.utanalysis;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.utsoft.commons.utanalysis_lib.UTAnalysisManager;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //测试：获取app的版本号
        String version = UTAnalysisManager.analysisAppVersion(this);
        Log.e(TAG,"当前应用版本号为：" + version);
        Log.e(TAG,"手机型号是：" + UTAnalysisManager.analysisModel());
        Log.e(TAG,"手机制造厂商是：" + UTAnalysisManager.analysisManufacturer());
        Log.e(TAG,"手机系统版本号：" + UTAnalysisManager.analysisVersionRelease());
        Log.e(TAG,"手机系统API是：" + UTAnalysisManager.analysisSDK() + "");
//        Log.e(TAG,"手机系统时间是：" + UTAnalysisManager.analysisTime());
        Log.e(TAG,"手机驱动是：" + UTAnalysisManager.analysisDevice());
        Log.e(TAG,"整个设备名称是：" + UTAnalysisManager.analysisProduct());
        Log.e(TAG,"手机唯一标识是：" + UTAnalysisManager.analysisFingerprint());
        Log.e(TAG,"设备主机地址是：" + UTAnalysisManager.analysisHost());
        Log.e(TAG,"设备版本号是：" + UTAnalysisManager.analysisID());
        Log.e(TAG,"设备硬件名称是：" + UTAnalysisManager.analysisHardware());
        Log.e(TAG,"设备CPU是：" + UTAnalysisManager.analysisCPUABI() + "----------------" +Build.CPU_ABI2);
    }
}
