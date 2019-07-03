package com.alexanderbaranov.productmanagement.service;

import com.alexanderbaranov.productmanagement.model.Item;
import com.alexanderbaranov.productmanagement.service.response.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> findAll();

    ItemDto findById(Long id);

    Item update(Item item);

    void deleteById(Long id);

    List<ItemDto> findByType(String type);

    void save(Item item);

}
