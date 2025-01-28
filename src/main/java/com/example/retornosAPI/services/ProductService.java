package com.example.retornosAPI.services;

import com.example.retornosAPI.dtos.PostProductDTO;
import com.example.retornosAPI.dtos.ProductDTO;
import com.example.retornosAPI.exeptions.ProductNotFoundException;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ProductDTO getProductById(Long id) throws ProductNotFoundException {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        return new ProductDTO(entity.getId(), entity.getName(), entity.getDescription(),
                entity.getPrice(), entity.getStock(), entity.getCategory());
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> allProducts = repository.findAll();
        return allProducts.stream()
                .map(ProductDTO::entityToDTO).toList();
    }

    public void deleteProduct(Long id) throws ProductNotFoundException {
        ProductEntity product = repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        repository.deleteById(product.getId());
    }

    // Atualizar um produto existente
    public ProductDTO updateProduct(Long id, PostProductDTO updatedProduct) throws ProductNotFoundException {
        // Verificar se o produto existe
        ProductEntity existingEntity = repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        // Atualizar os dados do produto
        existingEntity.setName(updatedProduct.name());
        existingEntity.setDescription(updatedProduct.description());
        existingEntity.setPrice(updatedProduct.price());
        existingEntity.setStock(updatedProduct.stock());
        existingEntity.setCategory(updatedProduct.category());

        // Salvar as alterações no banco de dados
        ProductEntity savedEntity = repository.save(existingEntity);

        // Retornar o produto atualizado
        return new ProductDTO(savedEntity.getId(), savedEntity.getName(),
                savedEntity.getDescription(), savedEntity.getPrice(), savedEntity.getStock(), savedEntity.getCategory());
    }

    // Buscar produtos pelo nome
    public List<ProductDTO> getProductsByName(String name) throws ProductNotFoundException {
       List<ProductEntity> productsByName = repository.findByNameContainingIgnoreCase(name);
       if (productsByName.isEmpty()) {
           throw new ProductNotFoundException();
       }
       return productsByName.stream().map(ProductDTO::entityToDTO).toList();
    }
}