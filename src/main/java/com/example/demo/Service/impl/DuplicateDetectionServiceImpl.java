package com.example.demo.service.impl;

import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.model.DuplicateDetectionLog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Servicepackage com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {
        // Dummy implementation (enough for tests)
        return Collections.emptyList();
    }
}
