// @Service
// @RequiredArgsConstructor
// public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

//     private final TicketRepository ticketRepository;
//     private final DuplicateRuleRepository ruleRepository;
//     private final DuplicateDetectionLogRepository logRepository;

//     @Override
//     public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {

//         Ticket sourceTicket = ticketRepository.findById(ticketId)
//                 .orElseThrow(() -> new RuntimeException("Ticket not found"));

//         // Fetch open tickets excluding current
//         List<Ticket> openTickets = ticketRepository
//                 .findByStatusAndIdNot(TicketStatus.OPEN, ticketId);

//         List<DuplicateRule> activeRules = ruleRepository.findByActiveTrue();
//         List<DuplicateDetectionLog> logs = new ArrayList<>();

//         for (Ticket targetTicket : openTickets) {
//             for (DuplicateRule rule : activeRules) {

//                 boolean match = false;
//                 double similarityScore = 0.0;

//                 switch (rule.getType()) {

//                     case EXACT_MATCH:
//                         match = sourceTicket.getDescription()
//                                 .equalsIgnoreCase(targetTicket.getDescription());
//                         similarityScore = match ? 1.0 : 0.0;
//                         break;

//                     case KEYWORD:
//                         match = targetTicket.getDescription()
//                                 .toLowerCase()
//                                 .contains(rule.getKeyword().toLowerCase());
//                         similarityScore = match ? 1.0 : 0.0;
//                         break;

//                     case SIMILARITY:
//                         similarityScore = TextSimilarityUtil.similarity(
//                                 sourceTicket.getDescription(),
//                                 targetTicket.getDescription()
//                         );
//                         match = similarityScore >= rule.getThreshold();
//                         break;
//                 }

//                 if (match) {
//                     DuplicateDetectionLog log = new DuplicateDetectionLog();
//                     log.setTicket(sourceTicket);
//                     log.setMatchedTicket(targetTicket);
//                     log.setRule(rule);
//                     log.setSimilarityScore(similarityScore);
//                     log.setDetectedAt(LocalDateTime.now());

//                     logs.add(logRepository.save(log));
//                 }
//             }
//         }
//         return logs;
//     }

//     @Override
//     public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
//         return logRepository.findByTicketId(ticketId);
//     }

//     @Override
//     public DuplicateDetectionLog getLog(Long id) {
//         return logRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Duplicate log not found"));
//     }
// }
