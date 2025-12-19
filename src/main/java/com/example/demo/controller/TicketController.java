import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;




@RestController
@RequestMapping("/api/tickets")
@Tag(name = "Tickets", description = "Ticket management APIs")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/{userId}/{categoryId}")
    public ResponseEntity<Ticket> createTicket(
            @PathVariable Long userId,
            @PathVariable Long categoryId,
            @RequestBody Ticket ticket) {

        return ResponseEntity.ok(
                ticketService.createTicket(userId, categoryId, ticket)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ticket>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(ticketService.getTicketsByUser(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAll() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicket(id));
    }
}
