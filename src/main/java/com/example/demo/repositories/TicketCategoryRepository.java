package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.TicketCategory;
@Repository
public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {

    boolean existsByCategoryName(String categoryName);
}
