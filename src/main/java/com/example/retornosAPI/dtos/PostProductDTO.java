package com.example.retornosAPI.dtos;

import com.example.retornosAPI.models.ProductEntity;
import jakarta.validation.constraints.*;

public record PostProductDTO(
        @NotBlank(message = "O nome não pode ser vazio")
        @NotNull(message = "O nome não pode ser nulo")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String name,
        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
        String description,
        @NotBlank(message = "O preço não pode ser vazio")
        @NotNull(message = "O preço não pode ser nulo")
        @DecimalMin(value = "0.01", inclusive = true, message = "O preço deve ser maior que zero")
        Double price,
        @NotBlank(message = "O estoque não pode ser vazio")
        @NotNull(message = "O estoque não pode ser nulo")
        @Min(value = 0, message = "O estoque deve ser um número inteiro maior ou igual a zero")
        int stock,
        @NotBlank(message = "A categoria não pode ser vazia")
        @NotNull(message = "A categoria não pode ser nula")
        @Pattern(regexp = "Eletrônicos|Roupas|Alimentos", message = "A categoria deve ser Eletrônicos, Roupas ou Alimentos")
        String category) {

    public ProductEntity dtoToEntity() {
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setStock(stock);
        newProduct.setCategory(category);
        return newProduct;
    }
}
