package com.crud.controller;
import com.crud.model.Product;
import com.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * GET /api/products?page={page}
     * Fetch all products with pagination.
     */
    @GetMapping
    public Page<Product> getAllProducts(@RequestParam int page) {
        return productService.getAllProducts(page);
    }

    /**
     * POST /api/products
     * Create a new product.
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * GET /api/products/{id}
     * Fetch a single product by its ID.
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    /**
     * PUT /api/products/{id}
     * Update an existing product by its ID.
     */
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    /**
     * DELETE /api/products/{id}
     * Delete a product by its ID.
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}

