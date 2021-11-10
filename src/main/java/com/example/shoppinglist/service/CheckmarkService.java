package com.example.shoppinglist.service;

import com.example.shoppinglist.model.Item;
import com.example.shoppinglist.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckmarkService {
    @Autowired
    ItemRepository itemRepository;

    public Boolean isDone(Long itemId) {
        Item item = itemRepository.findById(itemId).get();
        item.setDone();
        itemRepository.save(item);
        return item.getDone();
    }
}
