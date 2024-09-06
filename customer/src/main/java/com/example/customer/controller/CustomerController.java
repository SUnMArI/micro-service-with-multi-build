package com.example.customer.controller;

import com.example.customer.model.dto.request.CustomerRequest;
import com.example.customer.model.dto.response.ApiResponse;
import com.example.customer.model.dto.response.CustomerResponse;
import com.example.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<?> post(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.post(customerRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("A new customer is created")
                        .status(HttpStatus.OK)
                        .payload(customerResponse)
                        .timestamp(LocalDateTime.now()).build());
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<CustomerResponse> customerResponse = customerService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Customer was found successfully")
                        .status(HttpStatus.OK)
                        .payload(customerResponse)
                        .timestamp(LocalDateTime.now()).build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CustomerResponse customerResponse = customerService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Customer was found successfully")
                        .status(HttpStatus.OK)
                        .payload(customerResponse)
                        .timestamp(LocalDateTime.now()).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.updateById(id,customerRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Customer was updated successfully")
                        .status(HttpStatus.OK)
                        .payload(customerResponse)
                        .timestamp(LocalDateTime.now()).build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Boolean customerResponse = customerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.builder()
                        .message("Customer was deleted successfully")
                        .status(HttpStatus.OK)
                        .payload(customerResponse)
                        .timestamp(LocalDateTime.now()).build());
    }

}
