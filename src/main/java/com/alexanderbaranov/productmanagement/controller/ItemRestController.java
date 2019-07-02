package com.alexanderbaranov.productmanagement.controller;

import com.alexanderbaranov.productmanagement.exceptions.NotFoundException;
import com.alexanderbaranov.productmanagement.model.Item;
import com.alexanderbaranov.productmanagement.service.ItemService;
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
    public Item itemInsert(@RequestBody Item item) {
        itemService.save(item);
        return item;
    }

    @GetMapping()
        public List<Item> list() {
        return itemService.findAll();
    }

    @GetMapping("id/{id}")

    public Item getItemByID (@PathVariable Long id) {
        Item currentItem = itemService.findById(id);
         if (currentItem == null) {
             throw new NotFoundException();
                 }
        return currentItem;
    }

    @GetMapping("type/{type}")
    public List<Item> getItemByType (@PathVariable String type) {
        List <Item> currentItem = itemService.findByType(type);
        if (currentItem.size() == 0) {
            throw new NotFoundException();
        }
        return currentItem;
    }

    @GetMapping("type")
    public List<Item> getItemByNullType (String type) {
        type = "";
        return itemService.findByType(type);
    }

    @PutMapping("/{id}")
    public Item updateById (@PathVariable Long id, @RequestBody Item item) {
        Item currentItem = new Item(id, item.getName(), item.getPrice(), item.getDescription(), item.getType());
        itemService.update(currentItem);
         return currentItem;
    }

    @DeleteMapping("/{id}")
    public void delItemByID (@PathVariable Long id) {
        itemService.deleteById(id);
    }
}

