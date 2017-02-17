package cn.utsoft.commons.utanalysis_lib.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cn.utsoft.commons.utanalysis_lib.config.AnalysisConfig;

/**
 * Create by 任新 on 2017/2/17 11:53
 * Function：统计信息库
 * Desc：
 */
public class DBHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "analysis.db";
    private static final int VERSION = 1;

    private static final String SQL_DROP = "drop table if exists " + AnalysisConfig.ANALYSIS_TABLE;
    private static DBHelper sHelper = null;
    private static final String SQL_CREATE = "create table" + AnalysisConfig.ANALYSIS_TABLE
            + "(_id integer primary key autoincrement,"
            + "";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    public static DBHelper getInstance(Context context) {
        if (sHelper == null) {
            sHelper = new DBHelper(context);
        }
        return sHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP);
        db.execSQL(SQL_CREATE);
    }
}

