package com.example.shoppinglist;

import com.example.shoppinglist.model.Item;
import com.example.shoppinglist.repository.ItemRepository;
import com.example.shoppinglist.service.ItemService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemsTests {
    @MockBean
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @Test
    public void addItemTest() {
        Item item = itemService.create("jjj");
        Mockito.verify(itemRepository, Mockito.times(1)).save(item);
    }

    @Test
    public void markDoneTest() {
        Item item = new Item(1L, "ipsum lorem");
        item.setDone();
        Assert.assertTrue(item.getDone());
    }
}
