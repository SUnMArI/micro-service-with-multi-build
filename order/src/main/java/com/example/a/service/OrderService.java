package com.example.a.service;
import com.example.a.model.dto.request.OrderRequest;
import com.example.a.model.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse post(OrderRequest customerRequest);

    List<OrderResponse> findAll();

    OrderResponse findById(Long id);

    OrderResponse updateById(Long id, OrderRequest customerRequest);

    Boolean deleteById(Long id);
}
