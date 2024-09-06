package com.example.customer.model.dto.request;

import com.example.customer.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequest {
    private String name;
    private String email;
    public Customer toEntity(){
        return new Customer(null,this.name,this.email);
    };
}
