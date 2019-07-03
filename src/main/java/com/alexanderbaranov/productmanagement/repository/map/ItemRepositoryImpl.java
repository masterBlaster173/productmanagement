package com.alexanderbaranov.productmanagement.repository.map;

import com.alexanderbaranov.productmanagement.model.Item;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, Item> mapOfItems = new HashMap<>();

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();

        for (Map.Entry<Long, Item> entry : mapOfItems.entrySet()) {
            itemList.add(entry.getValue());
        }
        return itemList;
    }

    @Override
    public Item findById(Long id) {
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
    public List<Item> findByType(String type) {
        List<Item> itemList = new ArrayList<>();
        if (type != null) {
            for (Map.Entry<Long, Item> entry : mapOfItems.entrySet()) {
                if (type.equals(entry.getValue().getType())) {
                    itemList.add(entry.getValue());
                }
            }
            return itemList;
        } else return Collections.emptyList();
    }

    @Override
    public void save(Item item) {
        if ((item != null)) {
            item.setId(counter.incrementAndGet());
            if ((item.getType() != null)) {
                mapOfItems.put(item.getId(), item);
            }
        }
    }

    @Override
    public void deleteById(Long id) {
        mapOfItems.remove(id);
    }

    @Override
    public Item update(Item item) {
        if ((item != null)) {
            if ((item.getType() != null)) {
                mapOfItems.put(item.getId(), item);
            }
        }
        return item;
    }
}
