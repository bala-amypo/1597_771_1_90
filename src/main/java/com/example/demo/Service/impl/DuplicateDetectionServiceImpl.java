package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }

    @Override
    public List<DuplicateDetectionLog> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {
        // Example logic: filter logs for the given ticket
        return logRepository.findAll().stream()
                .filter(log -> log.getTicket() != null && log.getTicket().getId().equals(ticketId))
                .collect(Collectors.toList());
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findAll().stream()
                .filter(log -> log.getTicket() != null && log.getTicket().getId().equals(ticketId))
                .collect(Collectors.toList());
    }
}
