package com.example.a.service.serviceImp;



import com.example.a.feign.CustomerFeign;
import com.example.a.feign.ProductFeign;
import com.example.a.model.dto.request.OrderRequest;
import com.example.a.model.dto.response.OrderResponse;
import com.example.a.model.entity.Order;
import com.example.a.repository.OrderRepository;
import com.example.a.service.OrderService;
import com.example.customer.model.dto.response.CustomerResponse;
import com.example.product.model.dto.response.ProductResponse;
import com.example.product.model.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerFeign customerFeign;
    private final ProductFeign productFeign;
    @Override
    public OrderResponse post(OrderRequest customerRequest) {
        CustomerResponse customerResponse = Objects.requireNonNull(customerFeign
                .getCustomerById(customerRequest.getCustomerId())
                .getBody()).getPayload();
        List<ProductResponse> productResponses;
        productResponses = customerRequest.getProductIds().stream().map(productId ->{
            return productFeign
          .getProductById(productId)
          .getBody().getPayload();
        } ).toList();
        OrderResponse orderResponse = new OrderResponse(
                orderRepository.save(customerRequest.toEntity()).getId()
                ,customerResponse
                ,productResponses);
        return orderResponse;
    }

    @Override
    public List<OrderResponse> findAll() {
         List<Order> order = orderRepository.findAll();
       return order.stream().map(order1 -> new OrderResponse(order1.getId(), customerFeign.getCustomerById(order1.getCustomerId()).getBody().getPayload()
                ,order1.getProductId().stream().map(e->{
            return productFeign.getProductById(e).getBody().getPayload();
        }).toList())).toList();
    }

    @Override
    public OrderResponse findById(Long id) {
        return orderRepository.findById(id).map(e->{return new OrderResponse(
                e.getId(),
                customerFeign.getCustomerById(e.getCustomerId()).getBody().getPayload(),
                e.getProductId().stream().map(e1->{return productFeign.getProductById(e1).getBody().getPayload();}).toList()
        );}).get();
    }

    @Override
    public OrderResponse updateById(Long id, OrderRequest orderRequest) {
       orderRepository.findById(id).map(e->{
            e.setCustomerId(orderRequest.getCustomerId());
            e.setProductId(orderRequest.getProductIds());
           return orderRepository.save(e);
        });
        return orderRepository.findById(id).map(e->{return new OrderResponse(
                e.getId(),
                customerFeign.getCustomerById(e.getCustomerId()).getBody().getPayload(),
                e.getProductId().stream().map(e1->{return productFeign.getProductById(e1).getBody().getPayload();}).toList()
        );}).get();
    }

    @Override
    public Boolean deleteById(Long id) {
        orderRepository.deleteById(id);
        return true;
    }
}
