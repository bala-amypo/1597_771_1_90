package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TicketCategory;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {

    Optional<TicketCategory> findByCategoryName(String categoryName);

    boolean existsByCategoryName(String categoryName);
}
