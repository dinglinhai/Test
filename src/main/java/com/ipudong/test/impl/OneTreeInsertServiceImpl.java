package com.ipudong.test.impl;


import com.ipudong.test.dao.OneTreePosDao;
import com.ipudong.test.entity.OneTreePosDO;

import com.ipudong.test.service.OneTreeInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneTreeInsertServiceImpl implements OneTreeInsertService {

    @Autowired
    private OneTreePosDao oneTreePosDao;

    @Override
    public Boolean insert(List<OneTreePosDO> list) {
        return oneTreePosDao.insertBatch(list);
    }
}
