package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository logRepository;
    private final TicketRepository ticketRepository;

    // Constructor
    public DuplicateDetectionServiceImpl(DuplicateDetectionLogRepository logRepository,
                                         TicketRepository ticketRepository) {
        this.logRepository = logRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public DuplicateDetectionLog createLog(DuplicateDetectionLog log) {
        return logRepository.save(log);
    }

    @Override
    public List<DuplicateDetectionLog> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public Optional<DuplicateDetectionLog> getLog(Long id) {
        return logRepository.findById(id);
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByBaseTicket_Id(ticketId);
    }

    @Override
    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }
}
