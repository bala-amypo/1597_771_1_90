package com.example.demo.service.impl; // replace with your actual package

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.example.demo.model.TicketCategory;          // replace with your actual model package
import com.example.demo.repository.TicketCategoryRepository; // replace with your actual repository package
import com.example.demo.service.TicketCategoryService;       // replace with your actual service interface package

@Service
@RequiredArgsConstructor
public class TicketCategoryServiceImpl implements TicketCategoryService {

    private final TicketCategoryRepository categoryRepository;

    @Override
    public TicketCategory createCategory(TicketCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<TicketCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public TicketCategory getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }
}
