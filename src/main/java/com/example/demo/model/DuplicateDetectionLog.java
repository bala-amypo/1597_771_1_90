package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

import java.time.LocalDateTime;

@Entity
@Table(name = "duplicate_detection_log")
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne(optional = false)
    @JoinColumn(name = "matched_ticket_id", nullable = false)
    private Ticket matchedTicket;

    @DecimalMin("0.0")
    private Double matchScore;

    private LocalDateTime detectedAt;

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
    }

    // ===== Getters and Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }
}
