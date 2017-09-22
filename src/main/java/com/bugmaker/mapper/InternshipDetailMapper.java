package com.bugmaker.mapper;

import com.bugmaker.bean.InternshipDetail;

import java.util.List;

public interface InternshipDetailMapper {

    List<InternshipDetail> selectInsTeacherByStuId(String id);
}
