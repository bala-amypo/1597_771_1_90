// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.TicketCategory;
// import com.example.demo.service.TicketCategoryService;

// @RestController
// @RequestMapping("/api/categories")
// public class TicketCategoryController {

//     private final TicketCategoryService categoryService;

//     public TicketCategoryController(TicketCategoryService categoryService) {
//         this.categoryService = categoryService;
//     }

//     // Create a new category
//     @PostMapping
//     public ResponseEntity<TicketCategory> createCategory(@RequestBody TicketCategory category) {
//         TicketCategory createdCategory = categoryService.createCategory(category);
//         return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
//     }

//     // Get all categories
//     @GetMapping
//     public ResponseEntity<List<TicketCategory>> getAllCategories() {
//         return ResponseEntity.ok(categoryService.getAllCategories());
//     }

//     // Get category by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<TicketCategory> getCategory(@PathVariable Long id) {
//         TicketCategory category = categoryService.getCategory(id);
//         return ResponseEntity.ok(category);
//     }
// }
