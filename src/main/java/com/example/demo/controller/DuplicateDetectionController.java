package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detection")
public class DuplicateDetectionController {

    // GET /api/detection/run/{ticketId} – run detection
    @GetMapping("/run/{ticketId}")
    public ResponseEntity<String> runDetection(@PathVariable Long ticketId) {
        // logic to run duplicate detection
        return ResponseEntity.ok("Duplicate detection started for ticketId: " + ticketId);
    }

    // GET /api/detection/ticket/{ticketId} – get logs by ticketId
    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<String> getLogsByTicket(@PathVariable Long ticketId) {
        // logic to fetch logs by ticketId
        return ResponseEntity.ok("Logs for ticketId: " + ticketId);
    }

    // GET /api/detection/{id} – get log by id
    @GetMapping("/{id}")
    public ResponseEntity<String> getLogById(@PathVariable Long id) {
        // logic to fetch log by id
        return ResponseEntity.ok("Log details for id: " + id);
    }
}
