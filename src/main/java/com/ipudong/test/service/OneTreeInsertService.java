package com.ipudong.test.service;


import com.ipudong.test.entity.OneTreePosDO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OneTreeInsertService {

    @Transactional
    Boolean insert(List<OneTreePosDO> list);
}
