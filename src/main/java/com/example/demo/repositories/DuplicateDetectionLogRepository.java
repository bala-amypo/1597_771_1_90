package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.DuplicateDetectionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface DuplicateDetectionLogRepository extends JpaRepository<DuplicateDetectionLog, Long> {

    // Must match the field name in DuplicateDetectionLog
    List<DuplicateDetectionLog> findByBaseTicket_Id(Long ticketId);
}
