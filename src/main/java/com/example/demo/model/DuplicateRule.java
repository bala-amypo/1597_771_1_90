// package com.example.demo.model;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.DecimalMax;
// import jakarta.validation.constraints.DecimalMin;
// import jakarta.validation.constraints.NotBlank;

// import java.time.LocalDateTime;

// @Entity
// @Table(
//     name = "duplicate_rule",
//     uniqueConstraints = @UniqueConstraint(columnNames = "ruleName")
// )
// public class DuplicateRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotBlank
//     private String ruleName;

//     @Column(nullable = false)
//     private String matchType; 
//     // KEYWORD / SIMILARITY / EXACT_MATCH

//     @DecimalMin("0.0")
//     @DecimalMax("1.0")
//     private Double threshold;

//     private LocalDateTime createdAt;

//     @PrePersist
//     public void prePersist() {
//         this.createdAt = LocalDateTime.now();
//     }

//     // getters and setters
// }
