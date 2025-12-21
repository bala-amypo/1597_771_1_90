// package com.example.demo.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;

// import java.time.LocalDateTime;

// @Entity
// public class Ticket {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;

//     @ManyToOne
//     @JoinColumn(name = "category_id", nullable = false)
//     private TicketCategory category;

//     @NotBlank
//     private String subject;

//     @NotBlank
//     @Size(min = 10)
//     private String description;

//     @Column(nullable = false)
//     private String status; // OPEN / IN_PROGRESS / RESOLVED / CLOSED

//     private LocalDateTime createdAt;

//     @PrePersist
//     public void prePersist() {
//         this.createdAt = LocalDateTime.now();
//         if (this.status == null) {
//             this.status = "OPEN";
//         }
//     }

//     // ----------- Getters and Setters -----------

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }

//     public TicketCategory getCategory() {
//         return category;
//     }

//     public void setCategory(TicketCategory category) {
//         this.category = category;
//     }

//     public String getSubject() {
//         return subject;
//     }

//     public void setSubject(String subject) {
//         this.subject = subject;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }

//     public LocalDateTime getCreatedAt() {
//         return createdAt;
//     }

//     public void setCreatedAt(LocalDateTime createdAt) {
//         this.createdAt = createdAt;
//     }
// }
