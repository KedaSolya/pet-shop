package com.shop.petshop.repository;


import com.shop.petshop.models.OrderInfo;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderInfo,Long> {
}
