package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "duplicate_detection_logs")
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "base_ticket_id")
    private Ticket baseTicket;

    @ManyToOne
    @JoinColumn(name = "matched_ticket_id")
    private Ticket matchedTicket;

    private String reason;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Ticket getBaseTicket() { return baseTicket; }
    public void setBaseTicket(Ticket baseTicket) { this.baseTicket = baseTicket; }

    public Ticket getMatchedTicket() { return matchedTicket; }
    public void setMatchedTicket(Ticket matchedTicket) { this.matchedTicket = matchedTicket; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
