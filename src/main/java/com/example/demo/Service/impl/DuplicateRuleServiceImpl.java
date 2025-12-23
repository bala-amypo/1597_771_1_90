package com.example.demo.service.impl;

import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository ruleRepository;

    public DuplicateRuleServiceImpl(DuplicateRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public DuplicateRule createRule(DuplicateRule rule) {
        // Check if rule name already exists
        Optional<DuplicateRule> existing = ruleRepository.findByRuleName(rule.getRuleName());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Rule with name '" + rule.getRuleName() + "' already exists");
        }

        // Validate threshold between 0.0 and 1.0
        if (rule.getThreshold() < 0.0 || rule.getThreshold() > 1.0) {
            throw new IllegalArgumentException("Threshold must be between 0.0 and 1.0");
        }

        // Save and return
        return ruleRepository.save(rule);
    }

    @Override
    public List<DuplicateRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public DuplicateRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rule not found"));
    }
}
