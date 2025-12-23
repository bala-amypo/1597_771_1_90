package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.DuplicateRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Repository
public interface DuplicateRuleRepository extends JpaRepository<DuplicateRule, Long> {

    // Used to enforce uniqueness of ruleName
    Optional<DuplicateRule> findByRuleName(String ruleName);
}
