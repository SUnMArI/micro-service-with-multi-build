package com.example.customer.service.serviceImp;

import com.example.customer.model.dto.request.CustomerRequest;
import com.example.customer.model.dto.response.CustomerResponse;
import com.example.customer.model.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public CustomerResponse post(CustomerRequest customerRequest) {
        return Customer.toResponse( customerRepository.save(customerRequest.toEntity()));
    }

    @Override
    public List<CustomerResponse> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(Customer::toResponse).toList();
    }

    @Override
    public CustomerResponse findById(Long id) {
        return Customer.toResponse(customerRepository.findById(id).orElseThrow());
    }

    @Override
    public CustomerResponse updateById(Long id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id).map(customer1 -> {
            customer1.setName(customerRequest.getName());
            customer1.setEmail(customerRequest.getEmail());
            return customerRepository.save(customer1);
        }).orElseThrow(()->new RuntimeException("User not found"));
        return Customer.toResponse(customer) ;
    }

    @Override
    public Boolean deleteById(Long id) {
        return customerRepository.findById(id).map(customer1 -> {
            customerRepository.delete(customer1);
            return true;
        }).orElseThrow(()->new RuntimeException("User not found"));
    }
}
