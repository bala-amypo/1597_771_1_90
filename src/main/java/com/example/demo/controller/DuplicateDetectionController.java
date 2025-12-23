package com.example.demo.controller;

import com.example.demo.model.DuplicateRule;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duplicate-rules")
public class DuplicateDetectionController {

    private final DuplicateRuleService ruleService;

    public DuplicateDetectionController(DuplicateRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public DuplicateRule createRule(@RequestBody DuplicateRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping
    public List<DuplicateRule> getAllRules() {
        return ruleService.getAllRules();
    }

    @GetMapping("/{id}")
    public DuplicateRule getRule(@PathVariable Long id) {
        return ruleService.getRule(id);
    }
}
