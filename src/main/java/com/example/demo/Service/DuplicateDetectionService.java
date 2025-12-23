package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;
import java.util.List;

public interface DuplicateDetectionService {

    void processDuplicates(List<DuplicateDetectionLog> logs);

    List<DuplicateDetectionLog> getLogsForTicket(Long ticketId);

    void detectDuplicates(Long ticketId);
}
