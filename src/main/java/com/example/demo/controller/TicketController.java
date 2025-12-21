package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Create a new ticket for a user in a specific category.
     */
    @PostMapping("/{userId}/{categoryId}")
    public ResponseEntity<Ticket> createTicket(
            @PathVariable Long userId,
            @PathVariable Long categoryId,
            @RequestBody Ticket ticket
    ) {
        Ticket createdTicket = ticketService.createTicket(userId, categoryId, ticket);
        return ResponseEntity.ok(createdTicket);
    }

    /**
     * Get all tickets created by a specific user.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ticket>> getTicketsByUser(@PathVariable Long userId) {
        List<Ticket> tickets = ticketService.getTicketsByUser(userId);
        return ResponseEntity.ok(tickets);
    }

    /**
     * Get all tickets in the system.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    /**
     * Get a ticket by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicket(id);
        return ResponseEntity.ok(ticket);
    }
}
