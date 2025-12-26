package com.example.demo.service.impl;

import com.example.demo.entity.Ticket;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    @Override
    public List<Ticket> findDuplicates(Ticket ticket, List<Ticket> allTickets) {
        List<Ticket> duplicates = new ArrayList<>();

        for (Ticket other : allTickets) {

            // ✅ NULL SAFE ID CHECK
            if (ticket.getId() != null && other.getId() != null &&
                    ticket.getId().equals(other.getId())) {
                continue;
            }

            if (ticket.getSubject() != null && other.getSubject() != null &&
                    ticket.getSubject().equalsIgnoreCase(other.getSubject())) {
                duplicates.add(other);
            }
        }
        return duplicates;
    }
}
