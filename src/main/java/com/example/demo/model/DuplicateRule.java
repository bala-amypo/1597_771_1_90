package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "duplicate_rules")
public class DuplicateRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private Double similarityThreshold;

    private Boolean active = true;

    // ---------- getters & setters ----------

    public Long getId() {
        return id;
    }    

    public void setId(Long id) {
        this.id = id;
    }    

    public String getRuleName() {
        return ruleName;
    }    

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }    

    public Double getSimilarityThreshold() {
        return similarityThreshold;
    }    

    public void setSimilarityThreshold(Double similarityThreshold) {
        this.similarityThreshold = similarityThreshold;
    }

    public Boolean getActive() {
        return active;
    }    

    public void setActive(Boolean active) {
        this.active = active;
    }
}
