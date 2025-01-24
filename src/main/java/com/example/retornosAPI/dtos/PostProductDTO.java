package com.example.retornosAPI.dtos;

import com.example.retornosAPI.models.ProductEntity;

public record PostProductDTO(Long id, String name, Double price, int stock, String category) {

    public ProductEntity dtoToEntity() {
        ProductEntity newProduct = new ProductEntity();
        newProduct.setId(id);
        newProduct.setName(name);
        newProduct.setPrice(price);
        newProduct.setStock(stock);
        newProduct.setCategory(category);
        return newProduct;
    }
}
