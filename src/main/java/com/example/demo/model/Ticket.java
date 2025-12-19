// package com.example.demo.model;

// import jakarta.persistence.*;
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
//             this.status = "OPEN"; // default status
//         }
//     }

//     // getters and setters
// }
