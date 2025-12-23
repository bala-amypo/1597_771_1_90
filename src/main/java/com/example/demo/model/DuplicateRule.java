package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "duplicate_rules")
public class DuplicateRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_name", nullable = false, unique = true)
    private String ruleName;

    @Column(name = "match_type", nullable = false)
    private String matchType;
    // Allowed values: KEYWORD, SIMILARITY, EXACT_MATCH

    @Column(nullable = false)
    private Double threshold;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // One-to-many relationship with DuplicateDetectionLog
    @OneToMany(mappedBy = "rule")
    private List<DuplicateDetectionLog> detectionLogs;

    // ================= CONSTRUCTORS =================

    // No-arg constructor
    public DuplicateRule() {
    }

    // Parameterized constructor (just assigns fields)
    public DuplicateRule(String ruleName, String matchType, Double threshold) {
        this.ruleName = ruleName;
        this.matchType = matchType;
        this.threshold = threshold;
    }

    // ================= LIFECYCLE CALLBACK =================

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<DuplicateDetectionLog> getDetectionLogs() {
        return detectionLogs;
    }

    public void setDetectionLogs(List<DuplicateDetectionLog> detectionLogs) {
        this.detectionLogs = detectionLogs;
    }
}
