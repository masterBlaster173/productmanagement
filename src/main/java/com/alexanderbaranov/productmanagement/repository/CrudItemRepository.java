package com.alexanderbaranov.productmanagement.repository;

import com.alexanderbaranov.productmanagement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CrudItemRepository  extends JpaRepository<Item, Long> {

    ArrayList<Item> findByType(String type);

}
