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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private TicketCategory category;

    private String subject;
    private String description;
    private String status;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "baseTicket", cascade = CascadeType.ALL)
    private List<DuplicateDetectionLog> baseDuplicateLogs;

    @OneToMany(mappedBy = "matchedTicket", cascade = CascadeType.ALL)
    private List<DuplicateDetectionLog> matchedDuplicateLogs;

    // --- Getters & Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public TicketCategory getCategory() { return category; }
    public void setCategory(TicketCategory category) { this.category = category; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<DuplicateDetectionLog> getBaseDuplicateLogs() { return baseDuplicateLogs; }
    public void setBaseDuplicateLogs(List<DuplicateDetectionLog> baseDuplicateLogs) { this.baseDuplicateLogs = baseDuplicateLogs; }

    public List<DuplicateDetectionLog> getMatchedDuplicateLogs() { return matchedDuplicateLogs; }
    public void setMatchedDuplicateLogs(List<DuplicateDetectionLog> matchedDuplicateLogs) { this.matchedDuplicateLogs = matchedDuplicateLogs; }
}
