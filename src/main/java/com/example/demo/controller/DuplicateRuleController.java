@RestController
@RequestMapping("/api/rules")
@Tag(name = "Duplicate Rules", description = "Duplicate detection rule APIs")
@RequiredArgsConstructor
public class DuplicateRuleController {

    private final DuplicateRuleService ruleService;

    @PostMapping
    public ResponseEntity<DuplicateRule> create(
            @RequestBody DuplicateRule rule) {
        return ResponseEntity.ok(ruleService.createRule(rule));
    }

    @GetMapping
    public ResponseEntity<List<DuplicateRule>> getAll() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DuplicateRule> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ruleService.getRule(id));
    }
}
