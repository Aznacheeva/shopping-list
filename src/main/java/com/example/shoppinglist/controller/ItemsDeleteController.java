package com.example.shoppinglist.controller;

import com.example.shoppinglist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemsDeleteController {
    @Autowired
    ItemService itemService;

    @RequestMapping(path = "item-delete/{id}", method = RequestMethod.POST)
    public String doDelete(@PathVariable("id") Long id) {
        itemService.delete(id);
        return "redirect:/";
    }
}
