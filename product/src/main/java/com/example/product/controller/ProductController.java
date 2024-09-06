package com.example.product.controller;


import com.example.product.model.dto.request.ProductRequest;
import com.example.product.model.dto.response.ApiResponse;
import com.example.product.model.dto.response.ProductResponse;
import com.example.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("")
    public ResponseEntity<?> post(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.post(productRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Product is created")
                        .status(HttpStatus.OK)
                        .payload(productResponse)
                        .timestamp(LocalDateTime.now()).build());
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ProductResponse> customerResponse = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Product was found successfully")
                        .status(HttpStatus.OK)
                        .payload(customerResponse)
                        .timestamp(LocalDateTime.now()).build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ProductResponse productResponse = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Product was found successfully")
                        .status(HttpStatus.OK)
                        .payload(productResponse)
                        .timestamp(LocalDateTime.now()).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.updateById(id,productRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Product was updated successfully")
                        .status(HttpStatus.OK)
                        .payload(productResponse)
                        .timestamp(LocalDateTime.now()).build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Boolean productResponse = productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Product was deleted successfully")
                        .status(HttpStatus.OK)
                        .payload(productResponse)
                        .timestamp(LocalDateTime.now()).build());
    }

}
