package com.example.retornosAPI.controllers;

import com.example.retornosAPI.dtos.PostProductDTO;
import com.example.retornosAPI.dtos.ProductDTO;
import com.example.retornosAPI.exeptions.ProductNotFoundException;
import com.example.retornosAPI.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody PostProductDTO product) {
        ProductDTO newProduct = service.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws ProductNotFoundException {
        ProductDTO product = service.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ProductDTO>> getProductsByName(@PathVariable String name)
    throws ProductNotFoundException {
        List<ProductDTO> productsByName = service.getProductsByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(productsByName);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> allProducts = service.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(allProducts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id,
                                                    @RequestBody PostProductDTO product)
            throws ProductNotFoundException {
        ProductDTO productUpdated = service.updateProduct(id, product);
        return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}