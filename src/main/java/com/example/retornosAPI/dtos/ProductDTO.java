package com.example.retornosAPI.dtos;

import com.example.retornosAPI.models.ProductEntity;

public record ProductDTO(Long id, String name, Double price, int estoque, String categoria) {

    public static ProductDTO entidadeParaDTO (ProductEntity produto) {
        return new ProductDTO(
                produto.getId(), produto.getName(), produto.getPrice(),
                produto.getEstoque(), produto.getCategoria());
    }
}