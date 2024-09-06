package com.example.product.service.serviceImp;


import com.example.product.model.dto.request.ProductRequest;
import com.example.product.model.dto.response.ProductResponse;
import com.example.product.model.entity.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public ProductResponse post(ProductRequest productRequest) {
        return Product.toResponse(productRepository.save(productRequest.toEntity())) ;
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::toResponse).toList();
    }

    @Override
    public ProductResponse findById(Long id) {
        return Product.toResponse(productRepository.findById(id).orElseThrow(()->  new RuntimeException("")));
    }

    @Override
    public ProductResponse updateById(Long id, ProductRequest productRequest) {
        return Product.toResponse(productRepository.findById(id).map(product -> {
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            return productRepository.save(product);
        }).orElseThrow(()-> new RuntimeException("Product not found")));
    }

    @Override
    public Boolean deleteById(Long id) {
        return productRepository.findById(id).map(product -> {
          productRepository.delete(product);
          return true;
        }).orElseThrow(()-> new RuntimeException("Product not found"));
    }
}
