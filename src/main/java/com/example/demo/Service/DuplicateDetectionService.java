// package com.example.demo.service;

// import com.example.demo.model.DuplicateDetectionLog;
// import java.util.List;

// public interface DuplicateDetectionService {

//     DuplicateDetectionLog createLog(DuplicateDetectionLog log);

//     DuplicateDetectionLog getLog(Long id);

//     List<DuplicateDetectionLog> getAllLogs();

//     // Add these
//     List<DuplicateDetectionLog> detectDuplicates(Long ticketId);

//     List<DuplicateDetectionLog> getLogsForTicket(Long ticketId);
// }


package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;
import java.util.List;

public interface DuplicateDetectionService {

    void processDuplicates(List<DuplicateDetectionLog> logs);

    List<DuplicateDetectionLog> getLogsForTicket(Long ticketId);
}

