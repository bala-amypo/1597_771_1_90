package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private TicketCategory category;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ---------- getters & setters ----------

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

    public User getCreatedBy() {
        return createdBy;
    }    

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }    

    public TicketCategory getCategory() {
        return category;
    }    

    public void setCategory(TicketCategory category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
