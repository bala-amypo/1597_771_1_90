package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.CategoryValidationException;
import com.example.demo.model.TicketCategory;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.service.TicketCategoryService;

@Service
public class TicketCategoryServiceImpl implements TicketCategoryService {

    private final TicketCategoryRepository categoryRepository;

    public TicketCategoryServiceImpl(TicketCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public TicketCategory createCategory(TicketCategory category) {

        // Rule: categoryName must be unique
        if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
            throw new CategoryValidationException(
                "Category already exists with the same name"
            );
        }

        return categoryRepository.save(category);
    }

    @Override
    public List<TicketCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public TicketCategory getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new CategoryValidationException("Category not exists"));
    }
}
