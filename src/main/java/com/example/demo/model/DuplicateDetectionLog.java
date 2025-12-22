package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ THIS FIELD MUST EXIST
    @ManyToOne
    @JoinColumn(name = "rule_id")
    private DuplicateRule rule;

    // other fields...

    public DuplicateRule getRule() {
        return rule;
    }

    public void setRule(DuplicateRule rule) {
        this.rule = rule;
    }
}
