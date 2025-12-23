package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;

import java.util.List;

public interface DuplicateDetectionService {

    DuplicateDetectionLog createLog(DuplicateDetectionLog log);

    DuplicateDetectionLog getLog(Long id);

    List<DuplicateDetectionLog> getAllLogs();
}
