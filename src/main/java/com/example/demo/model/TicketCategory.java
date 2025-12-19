// package com.example.demo.model;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotBlank;

// import java.time.LocalDateTime;

/ / @Entity
// @Table(
//     name = "ticket_category",
//     uniqueConstraints = @UniqueConstraint(columnNames = "categoryName")
// )
// public class TicketCategory {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotBlank
//     private String categoryName;

//     private String description;

//     private LocalDateTime createdAt;

//     @PrePersist
//     public void prePersist() {
//         this.createdAt = LocalDateTime.now();
//     }

//     // getters and setters
// }
