package com.example.demo.service.impl;

import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository ruleRepository;

    public DuplicateRuleServiceImpl(DuplicateRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public DuplicateRule createRule(DuplicateRule rule) {
        ruleRepository.findByRuleName(rule.getRuleName()).ifPresent(r -> {
            throw new IllegalArgumentException("Rule already exists");
        });

        if (rule.getThreshold() < 0.0 || rule.getThreshold() > 1.0) {
            throw new IllegalArgumentException("Threshold must be between 0.0 and 1.0");
        }

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
