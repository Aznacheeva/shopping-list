package com.example.shoppinglist.service;

import com.example.shoppinglist.model.Item;
import com.example.shoppinglist.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Iterable<Item> listAllItems() {
        return itemRepository.findAll();
    }

    public void create(String text) {
        Item item = new Item(null, text);
        itemRepository.save(item);
    }

    public void delete(Long id) {
        Item item = itemRepository.findById(id).get();
        itemRepository.delete(item);
    }
}
