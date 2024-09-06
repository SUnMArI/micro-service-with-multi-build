package com.example.product.service;



import com.example.product.model.dto.request.ProductRequest;
import com.example.product.model.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse post(ProductRequest productRequest);

    List<ProductResponse> findAll();

    ProductResponse findById(Long id);

    ProductResponse updateById(Long id, ProductRequest productRequest);

    Boolean deleteById(Long id);
}
