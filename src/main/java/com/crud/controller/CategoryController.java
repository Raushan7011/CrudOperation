package com.crud.controller;


import com.crud.model.Category;
import com.crud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * GET /api/categories?page={page}
     * Fetch all categories with pagination.
     */
    @GetMapping
    public Page<Category> getAllCategories(@RequestParam int page) {
        return categoryService.getAllCategories(page);
    }

    /**
     * POST /api/categories
     * Create a new category.
     */
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    /**
     * GET /api/categories/{id}
     * Fetch a single category by its ID.
     */
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    /**
     * PUT /api/categories/{id}
     * Update an existing category by its ID.
     */
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    /**
     * DELETE /api/categories/{id}
     * Delete a category by its ID.
     */
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}

