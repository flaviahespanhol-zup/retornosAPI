package com.example.retornosAPI.dtos;

import com.example.retornosAPI.models.ProductEntity;

public record ProductDTO(Long id, String name, Double price, int stock, String category) {

    public static ProductDTO entityToDTO (ProductEntity produto) {
        return new ProductDTO(
                produto.getId(), produto.getName(), produto.getPrice(),
                produto.getStock(), produto.getCategory());
    }
}