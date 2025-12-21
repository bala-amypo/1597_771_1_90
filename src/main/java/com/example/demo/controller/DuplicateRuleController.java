import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;




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
