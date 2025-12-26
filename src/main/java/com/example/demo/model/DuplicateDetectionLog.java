package com.example.demo.model;

import java.time.LocalDateTime;

public class DuplicateDetectionLog {

    private Ticket ticket;
    private Ticket duplicateTicket;
    private double matchScore;
    private LocalDateTime detectedAt;

    public DuplicateDetectionLog() {
        this.detectedAt = LocalDateTime.now();
    }

    public DuplicateDetectionLog(Ticket ticket, Ticket duplicateTicket, double score) {
        this.ticket = ticket;
        this.duplicateTicket = duplicateTicket;
        this.matchScore = score;
        this.detectedAt = LocalDateTime.now();
    }

    public Ticket getTicket() { return ticket; }
    public Ticket getDuplicateTicket() { return duplicateTicket; }

    public double getMatchScore() { return matchScore; }
    public void setMatchScore(double matchScore) { this.matchScore = matchScore; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
}
