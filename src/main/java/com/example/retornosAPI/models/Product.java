package com.example.retornosAPI.models;

public record Product(Long id, String name, Double price, int estoque, String categoria) {
}