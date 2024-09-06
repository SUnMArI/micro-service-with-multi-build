package com.example.a.feign;//package com.example.order.feign;

import com.example.a.model.dto.response.ApiResponse;
import com.example.customer.model.dto.response.CustomerResponse;
import com.example.product.model.dto.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product", url = "http://localhost:8083/api/v1/product")
public interface ProductFeign {
    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<ProductResponse>> getProductById(@PathVariable("id") Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<ProductResponse>> deleteProductById(@PathVariable("id") Long id);
}
