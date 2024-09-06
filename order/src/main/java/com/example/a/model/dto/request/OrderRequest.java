package com.example.a.model.dto.request;

import com.example.a.model.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private Long customerId;
    private List<Long> productIds;
    public Order toEntity(){
        return  new Order(null,this.customerId,this.productIds, LocalDate.now());
    }
}
