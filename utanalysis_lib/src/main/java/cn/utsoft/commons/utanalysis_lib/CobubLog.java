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


import android.util.Log;

import cn.utsoft.commons.utanalysis_lib.UTAgent.LogLevel;

/**
 * @author Cobub Logger class is responsible for Log records.
 */
class CobubLog {

    public static void v(String tag,Class<?> classobj, String msg) {

        if (!UTConstants.DebugEnabled)
            return;

        if (UTConstants.DebugLevel == LogLevel.Debug
                || UTConstants.DebugLevel == LogLevel.Info
                || UTConstants.DebugLevel == LogLevel.Warn
                || UTConstants.DebugLevel == LogLevel.Error)
            return;

        Log.v(tag, classobj.getCanonicalName()+": "+ msg);
    }

    public static void d(String tag,Class<?> classobj, String msg) {

        if (!UTConstants.DebugEnabled)
            return;

        if (UTConstants.DebugLevel == LogLevel.Info
                || UTConstants.DebugLevel == LogLevel.Warn
                || UTConstants.DebugLevel == LogLevel.Error)
            return;

        Log.d(tag, classobj.getCanonicalName()+": "+ msg);
    }

    public static void i(String tag,Class<?> classobj, String msg) {

        if (!UTConstants.DebugEnabled)
            return;

        if (UTConstants.DebugLevel == LogLevel.Warn
                || UTConstants.DebugLevel == LogLevel.Error)
            return;

        Log.i(tag, classobj.getCanonicalName()+": "+ msg);
    }

    public static void w(String tag,Class<?> classobj, String msg) {

        if (!UTConstants.DebugEnabled)
            return;

        if (UTConstants.DebugLevel == LogLevel.Error)
            return;

        Log.w(tag, classobj.getCanonicalName()+": "+ msg);
    }

    public static void e(String tag,Class<?> classobj, String msg) {
        if (!UTConstants.DebugEnabled)
            return;
        Log.e(tag, classobj.getCanonicalName()+": "+ msg);
    }

    public static void e(String tag, Exception e) {
        if (!UTConstants.DebugEnabled)
            return;
        Log.e(tag, e.toString());
        e.printStackTrace();
    }
}
