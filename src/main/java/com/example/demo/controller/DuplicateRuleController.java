package com.example.demo.controller;

import com.example.demo.model.DuplicateRule;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class DuplicateRuleController {

    private final DuplicateRuleService duplicateRuleService;

    // ✅ Constructor injection
    public DuplicateRuleController(DuplicateRuleService duplicateRuleService) {
        this.duplicateRuleService = duplicateRuleService;
    }

    // ================= CREATE RULE =================
    // POST /api/rules
    @PostMapping
    public ResponseEntity<DuplicateRule> createRule(@RequestBody DuplicateRule rule) {
        DuplicateRule savedRule = duplicateRuleService.createRule(rule);
        return new ResponseEntity<>(savedRule, HttpStatus.CREATED);
    }

    // ================= GET ALL RULES =================
    // GET /api/rules
    @GetMapping
    public ResponseEntity<List<DuplicateRule>> getAllRules() {
        return ResponseEntity.ok(duplicateRuleService.getAllRules());
    }

    // ================= GET RULE BY ID =================
    // GET /api/rules/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DuplicateRule> getRule(@PathVariable Long id) {
        return ResponseEntity.ok(duplicateRuleService.getRule(id));
    }
}
