package com.example.demo.service.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository ruleRepository;

    // ✅ Constructor injection
    public DuplicateRuleServiceImpl(DuplicateRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    // ================= CREATE RULE =================
    @Override
    public DuplicateRule createRule(DuplicateRule rule) {

        // 🔴 Check unique rule name
        if (ruleRepository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("Rule already exists");
        }

        // 🔴 Threshold validation [0.0, 1.0]
        Double threshold = rule.getThreshold();
        if (threshold == null || threshold < 0.0 || threshold > 1.0) {
            throw new IllegalArgumentException("Threshold must be between 0.0 and 1.0");
        }

        // ✅ Save and return
        return ruleRepository.save(rule);
    }

    // ================= GET ALL RULES =================
    @Override
    public List<DuplicateRule> getAllRules() {
        return ruleRepository.findAll();
    }

    // ================= GET RULE BY ID =================
    @Override
    public DuplicateRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rule not found"));
    }
}
