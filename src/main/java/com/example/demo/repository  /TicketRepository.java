package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Ticket;
import org.springframework.stereotype.Repository;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByCategory_Id(long categoryId);

    List<Ticket> findBySubjectContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String subject, String description);
}
