public interface DuplicateRuleService {

    DuplicateRule createRule(DuplicateRule rule);

    List<DuplicateRule> getAllRules();

    DuplicateRule getRule(Long id);
}
