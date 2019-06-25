package com.alexanderbaranov.productmanagement.repository;

import com.alexanderbaranov.productmanagement.model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemRepositoryImplTest {
    ItemRepositoryImpl rep;

    @Before
    public void setUp() throws Exception {
        rep = new ItemRepositoryImpl();
    }
    @Test
    public void testFindByType1() {
        Item item = new Item(1L,"name",10D, "descr", "");
        rep.save(item);
        System.out.println( rep.findByType(""));
    }
}