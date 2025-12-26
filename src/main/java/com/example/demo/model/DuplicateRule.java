package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;
@Entity
public class DuplicateRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String field;
    private String matchType;
    private double threshold;

    public DuplicateRule() {}

    public DuplicateRule(String field, double threshold) {
        this.field = field;
        this.threshold = threshold;
    }

    public DuplicateRule(String field, String matchType, double threshold) {
        this.field = field;
        this.matchType = matchType;
        this.threshold = threshold;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getField() { return field; }
    public void setField(String field) { this.field = field; }

    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }

    public double getThreshold() { return threshold; }
    public void setThreshold(double threshold) { this.threshold = threshold; }
}
