package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;
@Table(name = "duplicate_rules")

@Entity
public class DuplicateRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DuplicateDetectionLog> detectionLogs;
}

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
