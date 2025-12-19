@RestController
@RequestMapping("/api/categories")
@Tag(name = "Ticket Categories", description = "Ticket category APIs")
@RequiredArgsConstructor
public class TicketCategoryController {

    private final TicketCategoryService categoryService;

    @PostMapping
    public ResponseEntity<TicketCategory> create(
            @RequestBody TicketCategory category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping
    public ResponseEntity<List<TicketCategory>> getAll() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketCategory> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
}
