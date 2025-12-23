package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "duplicate_detection_logs")
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
@JoinColumn(name = "base_ticket_id") // match your DB column
private Ticket baseTicket;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_id", nullable = false)
    private DuplicateRule rule;  // <-- Must exactly match mappedBy in DuplicateRule

    private String message;

    private LocalDateTime createdAt;

    // No-args constructor
    public DuplicateDetectionLog() {}

    // All-args constructor
    public DuplicateDetectionLog(Ticket ticket, DuplicateRule rule, String message, LocalDateTime createdAt) {
        this.ticket = ticket;
        this.rule = rule;
        this.message = message;
        this.createdAt = createdAt;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }

    public DuplicateRule getRule() { return rule; }
    public void setRule(DuplicateRule rule) { this.rule = rule; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
