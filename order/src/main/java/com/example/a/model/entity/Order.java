package com.example.a.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Table(name = "orders")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    private Long customerId;
    @ElementCollection
    @CollectionTable(name = "order-service", joinColumns = @JoinColumn(name = "order_id"))
    private List<Long> productId ;
    @CreationTimestamp
    private LocalDate orderDate;
}

