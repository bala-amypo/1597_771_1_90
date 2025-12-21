package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(
    name = "ticket_categories",
    uniqueConstraints = @UniqueConstraint(columnNames = "category_name")
)
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;

    @Column(length = 500)
    private String description;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Inverse side of relationship
    @OneToMany(mappedBy = "category")
    private List<Ticket> tickets;

    // No-arg constructor
    public TicketCategory() {
    }

    // Parameterized constructor
    public TicketCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    // Automatically set createdAt
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
