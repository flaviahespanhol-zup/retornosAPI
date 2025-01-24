package com.example.retornosAPI.dtos;

import com.example.retornosAPI.models.ProductEntity;

public record ProductDTO(Long id, String name, Double price, int stock, String category) {

    public static ProductDTO entityToDTO (ProductEntity product) {
        return new ProductDTO(
                product.getId(), product.getName(), product.getPrice(),
                product.getStock(), product.getCategory());
    }
}