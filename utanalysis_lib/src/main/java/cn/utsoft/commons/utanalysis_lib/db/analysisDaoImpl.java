package cn.utsoft.commons.utanalysis_lib.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import cn.utsoft.commons.utanalysis_lib.config.AnalysisConfig;
import cn.utsoft.commons.utanalysis_lib.entity.AnalysisInfo;

/**
 * Create by 任新 on 2017/2/17 13:32
 * Function：
 * Desc：
 */
public class AnalysisDaoImpl {
    private volatile static AnalysisDaoImpl impl;
    private DBHelper dbHelper = null;

    public static AnalysisDaoImpl getIns(Context context) {
        if (impl == null) {
            synchronized (AnalysisDaoImpl.class) {
                if (impl == null) {
                    impl = new AnalysisDaoImpl(context);
                }
            }
        }
        return impl;
    }

    private AnalysisDaoImpl(Context context) {
        this.dbHelper = DBHelper.getInstance(context);
    }

    /**
     * 添加统计信息
     *
     * @param analysisInfo
     */
    public void insertAnalysisInfo(AnalysisInfo analysisInfo) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put("", "");

        db.insert(AnalysisConfig.ANALYSIS_TABLE, null, values);

        db.close();
    }
}
