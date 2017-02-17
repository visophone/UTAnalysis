package cn.utsoft.commons.utanalysis_lib.db;

import cn.utsoft.commons.utanalysis_lib.entity.AnalysisInfo;

/**
 * Create by 任新 on 2017/2/17 13:31
 * Function：
 * Desc：
 */
public interface AnalysisDao {

    /**
     * 添加统计信息
     *
     * @param analysisInfo
     */
    void insertAnalysisInfo(AnalysisInfo analysisInfo);
}
