package com.bugmaker.mapper;

import com.bugmaker.BaseTest;
import com.bugmaker.bean.Company;
import com.bugmaker.bean.Survey;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by guan on 2017/9/21.
 */
public class SurveyMapperTest extends BaseTest {
    @Autowired
    SurveyMapper surveyMapper;

    @Test
    public void isUseForSurveyTest() {
        Survey useForSurvey = surveyMapper.isUseForSurvey();
        System.out.println(useForSurvey);

    }
}
