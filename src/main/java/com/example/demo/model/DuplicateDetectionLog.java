// package com.example.demo.model;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.DecimalMin;

// import java.time.LocalDateTime;

// @Entity
// public class DuplicateDetectionLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "ticket_id", nullable = false)
//     private Ticket ticket;

//     @ManyToOne
//     @JoinColumn(name = "matched_ticket_id", nullable = false)
//     private Ticket matchedTicket;

//     @DecimalMin("0.0")
//     private Double matchScore;

//     private LocalDateTime detectedAt;

//     @PrePersist
//     public void prePersist() {
//         this.detectedAt = LocalDateTime.now();
//     }

//     // getters and setters
// }
