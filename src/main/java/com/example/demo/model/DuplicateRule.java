package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "duplicate_rules")
public class DuplicateRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private double threshold;

    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DuplicateDetectionLog> detectionLogs; // <-- matches field 'rule' in DuplicateDetectionLog

    public DuplicateRule() {}

    public DuplicateRule(String ruleName, double threshold) {
        this.ruleName = ruleName;
        this.threshold = threshold;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public double getThreshold() { return threshold; }
    public void setThreshold(double threshold) { this.threshold = threshold; }

    public List<DuplicateDetectionLog> getDetectionLogs() { return detectionLogs; }
    public void setDetectionLogs(List<DuplicateDetectionLog> detectionLogs) { this.detectionLogs = detectionLogs; }
}
