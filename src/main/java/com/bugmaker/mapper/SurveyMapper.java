package com.bugmaker.mapper;

import com.bugmaker.bean.Survey;

/**
 * Created by guan on 2017/9/22.
 */
public interface SurveyMapper {
    /**
     *  判断调查表是否可用，查找最新的那一个调查表
     * @return
     */
    Survey isUseForSurvey();
}
