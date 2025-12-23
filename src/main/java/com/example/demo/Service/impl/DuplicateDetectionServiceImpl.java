package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DuplicateDetectionServiceImpl implements DuplicateDetectionLogService {

    private final DuplicateDetectionLogRepository logRepository;

    @Override
    public void processDuplicates(List<DuplicateDetectionLog> logs) {
        for (DuplicateDetectionLog log : logs) {
            Ticket baseTicket = log.getBaseTicket();
            Ticket matchedTicket = log.getMatchedTicket();

            // Example logic: print ticket IDs
            System.out.println("Base Ticket ID: " + baseTicket.getId());
            System.out.println("Matched Ticket ID: " + matchedTicket.getId());

            // Save log if needed
            logRepository.save(log);
        }
    }
}
