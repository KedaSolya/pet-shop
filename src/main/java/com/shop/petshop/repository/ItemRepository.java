package com.shop.petshop.repository;


import com.shop.petshop.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Long> {
}
