public interface DuplicateDetectionService {

    List<DuplicateDetectionLog> detectDuplicates(Long ticketId);

    List<DuplicateDetectionLog> getLogsForTicket(Long ticketId);

    DuplicateDetectionLog getLog(Long id);
}
