package com.example.a.model.dto.response;

import com.example.customer.model.dto.response.CustomerResponse;
import com.example.product.model.dto.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {
    private Long id;
    private CustomerResponse customerResponse;
    private List<ProductResponse> productResponse;
}
