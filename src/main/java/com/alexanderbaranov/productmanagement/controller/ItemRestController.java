package com.alexanderbaranov.productmanagement.controller;

import com.alexanderbaranov.productmanagement.exceptions.NotFoundException;
import com.alexanderbaranov.productmanagement.model.Item;
import com.alexanderbaranov.productmanagement.service.ItemService;
import com.alexanderbaranov.productmanagement.service.response.ItemDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemRestController {
    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping()
    public ItemDto itemInsert(@RequestBody ItemDto itemDto) {
        return itemService.save(itemDto);
    }

    @GetMapping()
    public List<ItemDto> list() {
        return itemService.findAll();
    }

    @GetMapping("id/{id}")

    public ItemDto getItemByID(@PathVariable Long id) {
        ItemDto currentItem = itemService.findById(id);
        if (currentItem == null) {
            throw new NotFoundException();
        }
        return currentItem;
    }

    @GetMapping("type/{type}")
    public List<ItemDto> getItemByType(@PathVariable String type) {
        List<ItemDto> currentItem = itemService.findByType(type);
        if (currentItem.size() == 0) {
            throw new NotFoundException();
        }
        return currentItem;
    }

    @GetMapping("type")
    public List<ItemDto> getItemByNullType(String type) {
        type = "";
        return itemService.findByType(type);
    }

    @PutMapping("/{id}")
    public ItemDto updateById(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return itemService.update(itemDto, id);
    }

    @DeleteMapping("/{id}")
    public void delItemByID(@PathVariable Long id) {
        itemService.deleteById(id);
    }
}

