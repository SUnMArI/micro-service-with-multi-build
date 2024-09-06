package com.example.a.controller;



import com.example.a.model.dto.request.OrderRequest;
import com.example.a.model.dto.response.ApiResponse;
import com.example.a.model.dto.response.OrderResponse;
import com.example.a.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> post(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.post(orderRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Order created")
                        .status(HttpStatus.OK)
                        .payload(orderResponse)
                        .timestamp(LocalDateTime.now()).build());
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<OrderResponse> orderResponses = orderService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Orders found")
                        .status(HttpStatus.OK)
                        .payload(orderResponses)
                        .timestamp(LocalDateTime.now()).build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        OrderResponse orderResponse = orderService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Order found")
                        .status(HttpStatus.OK)
                        .payload(orderResponse)
                        .timestamp(LocalDateTime.now()).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.updateById(id,orderRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Order updated successfully")
                        .status(HttpStatus.OK)
                        .payload(orderResponse)
                        .timestamp(LocalDateTime.now()).build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Boolean orderResponse = orderService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Order was deleted successfully")
                        .status(HttpStatus.OK)
                        .payload(orderResponse)
                        .timestamp(LocalDateTime.now()).build());
    }

}
