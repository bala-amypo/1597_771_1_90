package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "duplicate_detection_logs")
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ================= RULE =================
    @ManyToOne(optional = false)
    @JoinColumn(name = "rule_id", nullable = false)
    private DuplicateRule rule;

    // ================= BASE TICKET (FIXED NAME) =================
    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket baseTicket;

    // ================= MATCHED TICKET =================
    @ManyToOne(optional = false)
    @JoinColumn(name = "matched_ticket_id", nullable = false)
    private Ticket matchedTicket;

    // ================= FIELDS =================
    @Column(nullable = false)
    private Double matchScore;

    @Column(name = "detected_at", nullable = false)
    private LocalDateTime detectedAt;

    // ================= CONSTRUCTORS =================
    public DuplicateDetectionLog() {}

    public DuplicateDetectionLog(
            DuplicateRule rule,
            Ticket baseTicket,
            Ticket matchedTicket,
            Double matchScore
    ) {
        this.rule = rule;
        this.baseTicket = baseTicket;
        this.matchedTicket = matchedTicket;
        this.matchScore = matchScore;
    }

    @PrePersist
    protected void onDetect() {
        this.detectedAt = LocalDateTime.now();
    }

    // ================= GETTERS & SETTERS =================
    public Long getId() {
        return id;
    }

    public DuplicateRule getRule() {
        return rule;
    }

    public void setRule(DuplicateRule rule) {
        this.rule = rule;
    }

    public Ticket getBaseTicket() {
        return baseTicket;
    }

    public void setBaseTicket(Ticket baseTicket) {
        this.baseTicket = baseTicket;
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
