package com.example.demo.controller;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detection")
public class DuplicateDetectionController {

    private final DuplicateDetectionService duplicateDetectionService;

    // ✅ Constructor injection
    public DuplicateDetectionController(DuplicateDetectionService duplicateDetectionService) {
        this.duplicateDetectionService = duplicateDetectionService;
    }

    // =====================================================
    // 1️⃣ Run duplicate detection for a ticket
    // GET /api/detection/run/{ticketId}
    // =====================================================
    @GetMapping("/run/{ticketId}")
    public ResponseEntity<List<DuplicateDetectionLog>> runDetection(
            @PathVariable Long ticketId) {

        List<DuplicateDetectionLog> logs =
                duplicateDetectionService.detectDuplicates(ticketId);

        return ResponseEntity.ok(logs);
    }

    // =====================================================
    // 2️⃣ Get all logs for a ticket
    // GET /api/detection/ticket/{ticketId}
    // =====================================================
    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<DuplicateDetectionLog>> getLogsForTicket(
            @PathVariable Long ticketId) {

        return ResponseEntity.ok(
                duplicateDetectionService.getLogsForTicket(ticketId)
        );
    }

    // =====================================================
    // 3️⃣ Get a single detection log by ID
    // GET /api/detection/{id}
    // =====================================================
    @GetMapping("/{id}")
    public ResponseEntity<DuplicateDetectionLog> getLog(@PathVariable Long id) {
        return ResponseEntity.ok(duplicateDetectionService.getLog(id));
    }
}
