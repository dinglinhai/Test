package com.ipudong.test.service;


import com.ipudong.test.util.Result;

import java.text.ParseException;

public interface OneTreePosImportService {

    Result<Boolean> fetchPosFromOperations(Long startTime, Long endTime);
}
