package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repo;

    public TicketServiceImpl(TicketRepository repo) {
        this.repo = repo;
    }

    @Override
    public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
        return repo.save(ticket);
    }

    @Override
    public Ticket getTicket(Long ticketId) {
        return repo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    @Override
    public List<Ticket> getTicketsByUser(Long userId) {
        return repo.findAll();
    }

    @Override
    public List<Ticket> getAllTickets() {
        return repo.findAll();
    }
}
