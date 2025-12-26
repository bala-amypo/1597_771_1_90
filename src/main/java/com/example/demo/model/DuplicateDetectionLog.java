package com.example.demo.model;

import jakarta.persistence.*;
@Entity
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Ticket duplicateTicket;

    private double matchScore;

    private LocalDateTime detectedAt = LocalDateTime.now();

    public DuplicateDetectionLog() {}

    public DuplicateDetectionLog(Ticket ticket, Ticket duplicateTicket, double matchScore) {
        this.ticket = ticket;
        this.duplicateTicket = duplicateTicket;
        this.matchScore = matchScore;
    }

    public double getMatchScore() { return matchScore; }
    public void setMatchScore(double matchScore) { this.matchScore = matchScore; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
}

