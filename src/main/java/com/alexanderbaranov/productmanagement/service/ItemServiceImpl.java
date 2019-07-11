package com.alexanderbaranov.productmanagement.service;

import com.alexanderbaranov.productmanagement.model.Item;
import com.alexanderbaranov.productmanagement.repository.ItemRepository;
import com.alexanderbaranov.productmanagement.service.response.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper mapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper mapper) {
        this.itemRepository = itemRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ItemDto> findAll() {
        return mapper.toItemDto(itemRepository.findAll());
    }

    @Transactional
    @Override
    public ItemDto findById(Long id) {
        return mapper.toItemDto(itemRepository.findById(id));
    }

    @Transactional
    @Override
    public ItemDto update(ItemDto itemDto, Long id) {
        Item currentItem = new Item(id, itemDto.getName(), itemDto.getPrice(), itemDto.getDescription(), itemDto.getDescription());
        return mapper.toItemDto(itemRepository.update(currentItem));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        itemRepository.deleteById(id);

    }

    @Transactional
    @Override
    public List<ItemDto> findByType(String type) {
        return mapper.toItemDto(itemRepository.findByType(type));
    }

    @Transactional
    @Override
    public ItemDto save(ItemDto itemDto) {
        return mapper.toItemDto(itemRepository.save(mapper.toItem(itemDto)));

    }
}
