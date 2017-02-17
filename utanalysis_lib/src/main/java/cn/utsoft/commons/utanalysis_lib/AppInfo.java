/**
 * Cobub Razor
 *
 * An open source analytics android sdk for mobile applications
 *
 * @package     Cobub Razor
 * @author      WBTECH Dev Team
 * @copyright   Copyright (c) 2011 - 2015, NanJing Western Bridge Co.,Ltd.
 * @license     http://www.cobub.com/products/cobub-razor/license
 * @link        http://www.cobub.com/products/cobub-razor/
 * @since       Version 0.1
 * @filesource 
 */

package cn.utsoft.commons.utanalysis_lib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

class AppInfo {   
	private static String versionName = "";
    
    static String getAppKey(Context context) {
        	SharedPrefUtil sp = new SharedPrefUtil(context);
        	return sp.getValue("app_key", "");
    }

    static String getAppVersion(Context context) {
    	if(versionName.equals("")){
    		try {
                PackageManager pm = context.getPackageManager();
                PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
                if (pi != null) {
                    versionName = pi.versionName;
                }
            } catch (Exception e) {
            	AppInfo.class.getCanonicalName();
                CobubLog.e(UTConstants.LOG_TAG, AppInfo.class,e.toString());
            }
    	}
        return versionName;
    }
}
