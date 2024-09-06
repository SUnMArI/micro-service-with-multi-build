package com.example.customer.model.entity;

import com.example.customer.model.dto.response.CustomerResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    static public CustomerResponse toResponse(Customer customer) {
       return new CustomerResponse(customer.getId(), customer.getName(), customer.getEmail());
    }
}
