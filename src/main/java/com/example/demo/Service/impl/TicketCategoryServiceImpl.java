// @Service
// @RequiredConstructor
// public class TicketCategoryServiceImpl implements TicketCategoryService {

//     private final TicketCategoryRepository categoryRepository;

//     @Override
//     public TicketCategory createCategory(TicketCategory category) {
//         return categoryRepository.save(category);
//     }

//     @Override
//     public List<TicketCategory> getAllCategories() {
//         return categoryRepository.findAll();
//     }

//     @Override
//     public TicketCategory getCategory(Long id) {
//         return categoryRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
//     }
// }
