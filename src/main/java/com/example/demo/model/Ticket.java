package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String description;

    // --- Base duplicates ---
    @OneToMany(mappedBy = "baseTicket", cascade = CascadeType.ALL)
    private List<DuplicateDetectionLog> baseDuplicateLogs;

    // --- Matched duplicates ---
    @OneToMany(mappedBy = "matchedTicket", cascade = CascadeType.ALL)
    private List<DuplicateDetectionLog> matchedDuplicateLogs;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DuplicateDetectionLog> getBaseDuplicateLogs() {
        return baseDuplicateLogs;
    }

    public void setBaseDuplicateLogs(List<DuplicateDetectionLog> baseDuplicateLogs) {
        this.baseDuplicateLogs = baseDuplicateLogs;
    }

    public List<DuplicateDetectionLog> getMatchedDuplicateLogs() {
        return matchedDuplicateLogs;
    }

    public void setMatchedDuplicateLogs(List<DuplicateDetectionLog> matchedDuplicateLogs) {
        this.matchedDuplicateLogs = matchedDuplicateLogs;
    }
}
