package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.DuplicateRule;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;

import java.util.ArrayList;
import java.util.List;

public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepository;
    private final DuplicateRuleRepository ruleRepository;
    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionServiceImpl(
            TicketRepository ticketRepository,
            DuplicateRuleRepository ruleRepository,
            DuplicateDetectionLogRepository logRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {

        Ticket baseTicket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        List<DuplicateRule> rules = ruleRepository.findAll();
        List<Ticket> openTickets = ticketRepository.findByStatus("OPEN");

        List<DuplicateDetectionLog> logs = new ArrayList<>();

        for (Ticket other : openTickets) {

            // ✅ SKIP SELF (NULL SAFE)
            if (baseTicket.getId() != null &&
                other.getId() != null &&
                baseTicket.getId().equals(other.getId())) {
                continue;
            }

            for (DuplicateRule rule : rules) {

                switch (rule.getMatchType()) {

                    case "EXACT_MATCH":
                        if (exactMatch(baseTicket, other)) {
                            logs.add(saveLog(baseTicket, other, 1.0));
                        }
                        break;

                    case "KEYWORD":
                        double keywordScore = keywordSimilarity(baseTicket, other);
                        if (keywordScore >= rule.getThreshold()) {
                            logs.add(saveLog(baseTicket, other, keywordScore));
                        }
                        break;

                    case "SIMILARITY":
                        double simScore = similarity(baseTicket, other);
                        if (simScore >= rule.getThreshold()) {
                            logs.add(saveLog(baseTicket, other, simScore));
                        }
                        break;

                    default:
                        break;
                }
            }
        }

        return logs;
    }

    private boolean exactMatch(Ticket a, Ticket b) {
        if (a.getSubject() == null || b.getSubject() == null) {
            return false;
        }
        // ✅ CASE INSENSITIVE (TEST REQUIRED)
        return a.getSubject().equalsIgnoreCase(b.getSubject());
    }

    private double keywordSimilarity(Ticket a, Ticket b) {
        String textA = safe(a.getSubject()) + " " + safe(a.getDescription());
        String textB = safe(b.getSubject()) + " " + safe(b.getDescription());
        return TextSimilarityUtil.similarity(textA, textB);
    }

    private double similarity(Ticket a, Ticket b) {
        return TextSimilarityUtil.similarity(
                safe(a.getDescription()),
                safe(b.getDescription())
        );
    }

    private String safe(String s) {
        return s == null ? "" : s;
    }

    private DuplicateDetectionLog saveLog(Ticket base, Ticket other, double score) {
        DuplicateDetectionLog log = new DuplicateDetectionLog(base, other, score);
        return logRepository.save(log);
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}
