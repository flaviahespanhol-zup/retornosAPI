package com.example.retornosAPI.services;

import com.example.retornosAPI.dtos.PostProductDTO;
import com.example.retornosAPI.dtos.ProductDTO;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductDTO createProduct(PostProductDTO product) {
        ProductEntity newProductEntity = product.dtoToEntity();
        ProductEntity savedEntity = repository.save(newProductEntity);
        return ProductDTO.entityToDTO(savedEntity);
    }

    public ProductDTO getProductById(Long id) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductDTO(entity.getId(), entity.getName(), entity.getPrice(),
                entity.getStock(), entity.getCategory());
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> allProducts = repository.findAll();
        return allProducts.stream()
                .map(ProductDTO::entityToDTO).toList();
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    // Atualizar um produto existente
    public ProductDTO updateProduct(Long id, ProductDTO updatedProduct) {
        // Verificar se o produto existe
        ProductEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found"));

        // Atualizar os dados do produto
        existingEntity.setName(updatedProduct.name());
        existingEntity.setPrice(updatedProduct.price());

        // Salvar as alterações no banco de dados
        ProductEntity savedEntity = repository.save(existingEntity);

        // Retornar o produto atualizado
        return new ProductDTO(savedEntity.getId(), savedEntity.getName(), savedEntity.getPrice());
    }

    // Buscar produtos pelo nome
    public List<ProductDTO> getProductsByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }

        List<ProductEntity> entities = repository.findByNameContainingIgnoreCase(name);
        if (entities.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o nome: " + name);
        } else {
            System.out.println("Produtos encontrados com o nome '" + name + "': " + entities.size());
        }
        return entities.stream()
                .map(entity -> new ProductDTO(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toList());
    }
}