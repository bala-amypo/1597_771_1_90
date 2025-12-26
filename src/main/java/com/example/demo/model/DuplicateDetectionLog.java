package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "duplicate_detection_logs")
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketId;

    private Long duplicateTicketId;

    private Double similarityScore;

    private LocalDateTime detectedAt;

    @PrePersist
    public void onCreate() {
        this.detectedAt = LocalDateTime.now();
    }

    // ---------- getters & setters ----------

    public Long getId() {
        return id;
    }    

    public void setId(Long id) {
        this.id = id;
    }    

    public Long getTicketId() {
        return ticketId;
    }    

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }    

    public Long getDuplicateTicketId() {
        return duplicateTicketId;
    }    

    public void setDuplicateTicketId(Long duplicateTicketId) {
        this.duplicateTicketId = duplicateTicketId;
    }

    public Double getSimilarityScore() {
        return similarityScore;
    }    

    public void setSimilarityScore(Double similarityScore) {
        this.similarityScore = similarityScore;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }
}
