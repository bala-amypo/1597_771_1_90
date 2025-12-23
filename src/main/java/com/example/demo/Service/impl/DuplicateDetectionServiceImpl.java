package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionServiceImpl(DuplicateDetectionLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public DuplicateDetectionLog createLog(DuplicateDetectionLog log) {
        return logRepository.save(log);
    }

    @Override
    public DuplicateDetectionLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Log not found"));
    }

    @Override
    public List<DuplicateDetectionLog> getAllLogs() {
        return logRepository.findAll();
    }
}
