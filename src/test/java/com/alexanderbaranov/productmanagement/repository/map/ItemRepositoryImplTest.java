package com.alexanderbaranov.productmanagement.repository.map;

import com.alexanderbaranov.productmanagement.model.Item;
import com.alexanderbaranov.productmanagement.repository.AbstractRepositoryTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ItemRepositoryImplTest extends AbstractRepositoryTest {
    ItemRepository rep;

    @Before
        public void setUp() throws Exception {
            rep = new ItemRepositoryImpl();
    }
    @Test
    public void testFindByEmptyType() {
        Item item = new Item(1L,"name",10D, "descr", "");
        rep.save(item);
        List<Item> result = rep.findByType("");
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(item, result.get(0));
    }

    @Test
    public void testFindByNullType() {
        Item item = new Item(1L,"name",10D, "descr", "");
        rep.save(item);
        List<Item> result = rep.findByType(null);
        Assert.assertEquals(0, result.size());

    }

    @Test
    public void testFindItemWithNullTypeByNotNullType() {
        Item item = new Item(1L,"name",10D, "descr", null);
        rep.save(item);
        List<Item> result = rep.findByType("type");
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testFindNullItem() {
        Item item =null;
        rep.save(item);
        List<Item> result = rep.findAll();
        Assert.assertTrue(result.isEmpty());
    }
}