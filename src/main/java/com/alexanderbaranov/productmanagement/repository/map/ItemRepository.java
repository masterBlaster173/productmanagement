package com.alexanderbaranov.productmanagement.repository.map;

import com.alexanderbaranov.productmanagement.model.Item;

import java.util.List;

public interface ItemRepository {

    List<Item> findAll();

    Item findById(Long id);

    Item update(Item item);

    void deleteById(Long id);

    List<Item> findByType(String type);

    void save(Item item);
}
