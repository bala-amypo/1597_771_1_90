public interface TicketService {

    Ticket createTicket(Long userId, Long categoryId, Ticket ticket);

    Ticket getTicket(Long ticketId);

    List<Ticket> getTicketsByUser(Long userId);

    List<Ticket> getAllTickets();
}
