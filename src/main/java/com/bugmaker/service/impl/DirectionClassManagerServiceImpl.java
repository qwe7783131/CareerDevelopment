package com.bugmaker.service.impl;

import com.bugmaker.bean.DirectionClass;
import com.bugmaker.mapper.DirectionClassMapper;
import com.bugmaker.service.DirectionClassManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionClassManagerServiceImpl implements DirectionClassManagerService {

    @Autowired
    private DirectionClassMapper directionClassMapper;

    @Override
    public int mutiAddDirectinClass(List<DirectionClass> directionClasses) {
        return directionClassMapper.addMutiDirectionClass(directionClasses);
    }
}
