package cn.utsoft.commons.utanalysis_lib;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomParameterManager {
    Context context;
  
    public CustomParameterManager(Context context) {
        super();
        this.context = context;
    }

    public void getParameters() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("appKey", AppInfo.getAppKey(context));
            if (CommonUtil.isNetworkAvailable(context)
                    && CommonUtil.isNetworkTypeWifi(context)) {
                MyMessage message = NetworkUtil.Post(UTConstants.BASE_URL
                        + UTConstants.PARAMETER_URL, obj.toString());
                try {
                    CobubLog.d(UTConstants.LOG_TAG,CustomParameterManager.class, message.getMsg());
                    JSONObject result_obj = new JSONObject(message.getMsg())
                            .getJSONObject("reply");
                    if (result_obj.has("parameters")) {
                        JSONArray arr = result_obj.getJSONArray("parameters");
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject item = arr.getJSONObject(i);
                            SharedPrefUtil spu = new SharedPrefUtil(context);
                            spu.setValue(item.getString("key"),
                                    item.getString("value"));
                        }
                    }
                } catch (JSONException e1) {
                    CobubLog.e(UTConstants.LOG_TAG, e1);
                }
            }

        } catch (JSONException e) {
            CobubLog.e(UTConstants.LOG_TAG, e);
        }
    }

}
