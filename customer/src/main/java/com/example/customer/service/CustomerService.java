package com.example.customer.service;

import com.example.customer.model.dto.request.CustomerRequest;
import com.example.customer.model.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse post(CustomerRequest customerRequest);

    List<CustomerResponse> findAll();

    CustomerResponse findById(Long id);

    CustomerResponse updateById(Long id, CustomerRequest customerRequest);

    Boolean deleteById(Long id);
}
