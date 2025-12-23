package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.DuplicateDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository logRepository;
    private final TicketRepository ticketRepository;

    // Create a new duplicate detection log
    @Override
    public DuplicateDetectionLog createLog(DuplicateDetectionLog log) {
        return logRepository.save(log);
    }

    // Get all logs
    @Override
    public List<DuplicateDetectionLog> getAllLogs() {
        return logRepository.findAll();
    }

    // Get logs by ticket ID
    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        // Use the correct property name in DuplicateDetectionLog (baseTicket)
        return logRepository.findByBaseTicket_Id(ticketId);
    }

    // Find a specific log by ID
    @Override
    public Optional<DuplicateDetectionLog> getLogById(Long id) {
        return logRepository.findById(id);
    }

    // Delete a log by ID
    @Override
    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }
}
