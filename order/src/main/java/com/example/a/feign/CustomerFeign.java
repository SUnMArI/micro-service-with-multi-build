package com.example.a.feign;//package com.example.order.feign;

import com.example.a.model.dto.response.ApiResponse;
import com.example.customer.model.dto.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer" , url = "http://localhost:8081/api/v1/customer")
public interface CustomerFeign {
    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<CustomerResponse>> getCustomerById(@PathVariable("id") Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<CustomerResponse>> deleteCustomerById(@PathVariable("id") Long id);
}
