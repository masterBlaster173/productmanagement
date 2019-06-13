package com.alexanderbaranov.restproj1.repository;

import com.alexanderbaranov.restproj1.model.Item;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ItemRepositoryImpl implements ItemRepository {
    private final AtomicLong counter = new AtomicLong(); // for automatic increment ID
    private Map<Long, Item> mapOfItems = new HashMap<>();

    @Override
    public List<Item> findAll () {
        List<Item> itemList = new ArrayList<>();

        for (Map.Entry<Long, Item> entry : mapOfItems.entrySet()) {
            itemList.add(entry.getValue());
        }
        return itemList;
    }

    @Override
    public Item findById (Long id) {
        Item findItem = null;

        for (Map.Entry<Long, Item> entry : mapOfItems.entrySet()) {
            if (id == entry.getKey()) {
                findItem = entry.getValue();
                break;
            }
        }
        return findItem;
    }

    @Override
    public List<Item> findByType (String type) {
        List<Item> itemList = new ArrayList<>();

        for (Map.Entry<Long, Item> entry : mapOfItems.entrySet()) {
            if (type.equals(entry.getValue().getType())) {
                itemList.add(entry.getValue());
            }
        }
        return itemList;
    }

    @Override
    public void save (Item item) {
        item.setId(counter.incrementAndGet());
        mapOfItems.put(item.getId(), item);

    }

    @Override
    public void deleteById(Long id) {
        mapOfItems.remove(id);
    }

    @Override
    public Item update(Item item) {
      //  mapOfItems.remove(item.getId());
        mapOfItems.put(item.getId(), item);
        return item;
    }
}
