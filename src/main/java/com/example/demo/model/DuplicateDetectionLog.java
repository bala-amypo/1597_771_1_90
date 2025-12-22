package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "duplicate_detection_logs")
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Base ticket
    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    // Matched (duplicate) ticket
    @ManyToOne(optional = false)
    @JoinColumn(name = "matched_ticket_id", nullable = false)
    private Ticket matchedTicket;

    @Column(nullable = false)
    private Double matchScore;

    @Column(name = "detected_at", nullable = false)
    private LocalDateTime detectedAt;

    // ================= CONSTRUCTORS =================

    // No-arg constructor
    public DuplicateDetectionLog() {
    }

    // Parameterized constructor (just assigns fields)
    public DuplicateDetectionLog(Ticket ticket, Ticket matchedTicket, Double matchScore) {
        this.ticket = ticket;
        this.matchedTicket = matchedTicket;
        this.matchScore = matchScore;
    }

    // ================= LIFECYCLE CALLBACK =================

    @PrePersist
    protected void onDetect() {
        this.detectedAt = LocalDateTime.now();
    }

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getMatchedTicket() {
        return matchedTicket;
    }

    public void setMatchedTicket(Ticket matchedTicket) {
        this.matchedTicket = matchedTicket;
    }

    public Double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Double matchScore) {
        this.matchScore = matchScore;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }
}
