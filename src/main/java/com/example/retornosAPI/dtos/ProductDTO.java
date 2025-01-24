package com.example.retornosAPI.dtos;

import com.example.retornosAPI.models.ProductEntity;

public record ProductDTO(Long id, String name, String description, Double price, int stock, String category) {

    public static ProductDTO entityToDTO (ProductEntity product) {
        return new ProductDTO(
                product.getId(), product.getName(), product.getDescription(),
                product.getPrice(), product.getStock(), product.getCategory());
    }
}