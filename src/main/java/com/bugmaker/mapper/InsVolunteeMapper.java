package com.bugmaker.mapper;

import com.bugmaker.bean.InsVoluntee;
import com.bugmaker.bean.ProfessVolunteer;

/**
 * Created by guan on 2017/9/22.
 */
public interface InsVolunteeMapper {
    /**
     * 插入学生项目志愿
     * @param insVoluntee
     * @return
     */
    int insertInsVolunteer(InsVoluntee insVoluntee);

}
