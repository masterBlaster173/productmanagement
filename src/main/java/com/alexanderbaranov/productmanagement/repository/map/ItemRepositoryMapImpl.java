package com.alexanderbaranov.productmanagement.repository.map;

import com.alexanderbaranov.productmanagement.model.Item;
import com.alexanderbaranov.productmanagement.repository.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepositoryMapImpl implements ItemRepository {

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
    public Item save(Item item) {
        Long currentId = counter.incrementAndGet();
        Item currentItem = null;
        if ((item != null)) {
            item.setId(currentId);
            if ((item.getType() != null)) {
                mapOfItems.put(item.getId(), item);
            }
        }
        for (Map.Entry<Long, Item> entry : mapOfItems.entrySet()) {
            if (currentId == entry.getKey()) {
                currentItem = entry.getValue();
            }
        }
        return currentItem;
    }

    @Override
    public void deleteById(Long id) {
        mapOfItems.remove(id);
    }

    @Override
    public Item update(Item item) {
        Item currentItem = null;
        Long currentId = item.getId();
        if ((item != null)) {
            if ((item.getType() != null)) {
                mapOfItems.put(item.getId(), item);
            }
        }

        for (Map.Entry<Long, Item> entry : mapOfItems.entrySet()) {
            if (currentId == entry.getKey()) {
                currentItem = entry.getValue();
            }
        }
        return currentItem;
    }
}
