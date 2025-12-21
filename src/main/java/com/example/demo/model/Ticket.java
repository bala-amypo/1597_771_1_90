package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private TicketCategory category;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, length = 5000)
    private String description;

    @Column(nullable = false)
    private String status = "OPEN";

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "baseTicket")
    private List<DuplicateDetectionLog> baseDuplicateLogs;

    @OneToMany(mappedBy = "matchedTicket")
    private List<DuplicateDetectionLog> matchedDuplicateLogs;

    // No-arg constructor
    public Ticket() {
        this.createdAt = LocalDateTime.now();
        this.status = "OPEN";
    }

    // Parameterized constructor
    public Ticket(User user, TicketCategory category, String subject, String description) {
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("subject must not be blank");
        }
        if (description == null || description.length() < 10) {
            throw new IllegalArgumentException("description must have at least 10 characters");
        }

        this.user = user;
        this.category = category;
        this.subject = subject;
        this.description = description;
        this.status = "OPEN";
        this.createdAt = LocalDateTime.now();
    }

    // ----------------- Getters and Setters -----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TicketCategory getCategory() {
        return category;
    }

    public void setCategory(TicketCategory category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("subject must not be blank");
        }
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() < 10) {
            throw new IllegalArgumentException("description must have at least 10 characters");
        }
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
