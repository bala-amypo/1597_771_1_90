package com.example.demo.service.impl;
import com.example.demo.util.TextSimilarityUtil;

import com.example.demo.model.*;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepository;
    private final DuplicateRuleRepository ruleRepository;
    private final DuplicateDetectionLogRepository logRepository;

    // ✅ Constructor injection
    public DuplicateDetectionServiceImpl(
            TicketRepository ticketRepository,
            DuplicateRuleRepository ruleRepository,
            DuplicateDetectionLogRepository logRepository) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    // ================= DETECT DUPLICATES =================
    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {

        Ticket baseTicket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        List<DuplicateRule> rules = ruleRepository.findAll();
        if (rules.isEmpty()) {
            return Collections.emptyList();
        }

        List<Ticket> openTickets = ticketRepository.findByStatus("OPEN");
        List<DuplicateDetectionLog> createdLogs = new ArrayList<>();

        for (Ticket candidate : openTickets) {

            // ❌ Do not compare ticket with itself
            if (candidate.getId().equals(baseTicket.getId())) {
                continue;
            }

            for (DuplicateRule rule : rules) {

                Double score = null;

                // ===== EXACT MATCH =====
                if ("EXACT_MATCH".equalsIgnoreCase(rule.getMatchType())) {
                    if (baseTicket.getSubject() != null
                            && baseTicket.getSubject().equalsIgnoreCase(candidate.getSubject())) {
                        score = 1.0;
                    }
                }

                // ===== KEYWORD MATCH =====
                else if ("KEYWORD".equalsIgnoreCase(rule.getMatchType())) {
                    score = keywordOverlapScore(baseTicket, candidate);
                    if (score < rule.getThreshold()) {
                        score = null;
                    }
                }

                // ===== SIMILARITY MATCH =====
                else if ("SIMILARITY".equalsIgnoreCase(rule.getMatchType())) {
                    score = TextSimilarityUtil.similarity(
                            baseTicket.getDescription(),
                            candidate.getDescription()
                    );
                    if (score < rule.getThreshold()) {
                        score = null;
                    }
                }

                // ===== SAVE LOG IF DUPLICATE FOUND =====
                if (score != null) {
                    DuplicateDetectionLog log =
                            new DuplicateDetectionLog(baseTicket, candidate, score);
                    createdLogs.add(logRepository.save(log));
                }
            }
        }

        return createdLogs;
    }

    // ================= GET LOGS FOR TICKET =================
    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }

    // ================= GET LOG BY ID =================
    @Override
    public DuplicateDetectionLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }

    // ================= HELPER METHOD =================
    private double keywordOverlapScore(Ticket t1, Ticket t2) {

        Set<String> words1 = extractWords(t1.getSubject(), t1.getDescription());
        Set<String> words2 = extractWords(t2.getSubject(), t2.getDescription());

        if (words1.isEmpty() || words2.isEmpty()) {
            return 0.0;
        }

        Set<String> common = new HashSet<>(words1);
        common.retainAll(words2);

        return (double) common.size() / Math.min(words1.size(), words2.size());
    }

    private Set<String> extractWords(String subject, String description) {
        Set<String> words = new HashSet<>();

        String text = ((subject == null ? "" : subject) + " " +
                       (description == null ? "" : description))
                       .toLowerCase();

        for (String word : text.split("\\W+")) {
            if (!word.isBlank()) {
                words.add(word);
            }
        }
        return words;
    }
}
