package com.example.demo.Service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.Service.DuplicateDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository logRepository;

    @Override
    public void processDuplicates(List<DuplicateDetectionLog> logs) {
        for (DuplicateDetectionLog log : logs) {
            // Use getBaseTicket() and getMatchedTicket() instead of getTicket()
            Ticket baseTicket = log.getBaseTicket();
            Ticket matchedTicket = log.getMatchedTicket();

            // Example logic
            System.out.println("Base Ticket ID: " + baseTicket.getId());
            System.out.println("Matched Ticket ID: " + matchedTicket.getId());

            // Save log if needed
            logRepository.save(log);
        }
    }

    // Add other methods similarly, replacing getTicket() with getBaseTicket() or getMatchedTicket()
}
