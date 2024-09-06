package com.example.product.model.dto.request;

import com.example.product.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequest {
    private String name;
    private Double price;
    public Product toEntity() {
        return new Product(null,this.name,this.price);
    }
}
