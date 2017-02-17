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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.utsoft.commons.utanalysis_lib.UTAgent.SendPolicy;

class TagManager {

    private Context context;
    private String tags;

    public TagManager(Context context, String tags) {
        this.context = context;
        this.tags = tags;
    }

    private JSONObject prepareTagJSON() {
        JSONObject object = new JSONObject();
        try {
            object.put("tag", tags);
            object.put("deviceid", DeviceInfo.getDeviceId());
            object.put("appkey", AppInfo.getAppKey(context));
            object.put("useridentifier", CommonUtil.getUserIdentifier(context));
            object.put("lib_version", UTConstants.LIB_VERSION);
        } catch (JSONException e) {
            CobubLog.e(UTConstants.LOG_TAG, e);
        }
        return object;
    }

    public void PostTag() {
        JSONObject tagJSON;
        try {
            tagJSON = prepareTagJSON();
        } catch (Exception e) {
            CobubLog.e(UTConstants.LOG_TAG, e);
            return;
        }

        JSONObject postdata = new JSONObject();
        try {
            postdata.put("data", new JSONArray().put(tagJSON));
        } catch (JSONException e) {
            CobubLog.e(UTConstants.LOG_TAG, e);
        }

        if (CommonUtil.getReportPolicyMode(context) == SendPolicy.POST_NOW
                && CommonUtil.isNetworkAvailable(context)) {

            MyMessage message = NetworkUtil.Post(UTConstants.BASE_URL
                    + UTConstants.TAG_URL, postdata.toString());

            if (!message.isSuccess()) {
                CobubLog.e(UTConstants.LOG_TAG,TagManager.class, "Message=" + message.getMsg());

                CommonUtil.saveInfoToFile("tags", tagJSON, context);
            }
        } else {
            CommonUtil.saveInfoToFile("tags", tagJSON, context);
        }
    }
}
