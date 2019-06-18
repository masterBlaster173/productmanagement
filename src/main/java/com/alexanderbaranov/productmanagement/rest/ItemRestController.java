package com.alexanderbaranov.productmanagement.rest;

import com.alexanderbaranov.productmanagement.exceptions.NotFoundException;
import com.alexanderbaranov.productmanagement.model.Item;
import com.alexanderbaranov.productmanagement.repository.ItemRepository;
import com.alexanderbaranov.productmanagement.repository.ItemRepositoryImpl;
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

    /*Browser console request exapmle: fetch( '/item/', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name: 'name', price: '20.0', descrip: 'descrip', type: 'type' })
          })*/

    @PostMapping()
    public Item itemInsert(@RequestBody Item item) {
      // Item currentItem = new Item(item.getId(), item.getName(), item.getPrice(), item.getDescrip(), item.getType());
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
        return itemService.findByType(type);
    }

    @PutMapping("/{id}")
    public Item updateById (@PathVariable Long id, @RequestBody Item item) {
        Item currentItem = new Item(id, item.getName(), item.getPrice(), item.getDescription(), item.getType());
        itemService.update(currentItem);
         return currentItem;
    }

/*Browser console request example: fetch( '/item/1', {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' },
          })*/

    @DeleteMapping("/{id}")
    public void delItemByID (@PathVariable Long id) {
        itemService.deleteById(id);
    }
}

