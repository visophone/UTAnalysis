package cn.utsoft.commons.utanalysis_lib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by 任新 on 2017/2/15 15:56
 * Function：UT统计管理器
 * Desc：
 */
public class UTAnalysisManager {

    private static String mVersionName = "";

    /**
     * 获取app的版本号
     *
     * @param context
     * @return
     */
    public static String analysisAppVersion(Context context) {
        if (mVersionName.equals("")) {
            try {
                PackageManager pm = context.getPackageManager();
                PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
                if (pi != null) {
                    mVersionName = pi.versionName;
                }
            } catch (Exception e) {
                UTAnalysisManager.class.getCanonicalName();
            }
        }
        return mVersionName;
    }

    /**
     * 统计手机型号
     *
     * @return
     */
    public static String analysisModel() {
        return Build.MODEL;
    }

    /**
     * 统计手机厂商
     *
     * @return
     */
    public static String analysisManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * 统计系统版本字符串
     *
     * @return
     */
    public static String analysisVersionRelease() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 统计系统API
     *
     * @return
     */
    public static int analysisSDK() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 统计时间
     * 输出时间格式为: yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String analysisTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(Build.TIME);
        String time = simpleDateFormat.format(date);
        return time;
    }

    /**
     * 统计设备驱动名称
     *
     * @return
     */
    public static String analysisDevice(){
        return Build.DEVICE;
    }

    /**
     * 统计设备的唯一标识号
     *
     * @return
     */
    public static String analysisFingerprint(){
        return Build.FINGERPRINT;
    }

    /**
     * 统计设备主机地址
     *
     *@return
     */
    public static String analysisHost(){
        return Build.HOST;
    }

    /**
     * 统计设备的版本号
     *
     * @return
     */
    public static String analysisID(){
        return Build.ID;
    }

    /**
     * 统计设备硬件名称
     *
     * @return
     */
    public static String analysisHardware(){
        return Build.HARDWARE;
    }

    /**
     * 统计整个设备的名称
     *
     * @return
     */
    public static String analysisProduct(){
        return Build.PRODUCT;
    }

    /**
     * 统计设备指令集名称，即CPU的类型
     *
     * @return
     */
    public static String analysisCPUABI(){
        return Build.CPU_ABI;
    }

}

