package com.example.retornosAPI.exeptions;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException() {
        super("Produto não encontrado");
    }
}
