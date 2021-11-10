package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.Item;
import com.example.shoppinglist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemsViewController {
    @Autowired
    ItemService itemService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String list(Model model) {
        // TODO: 09.11.2021
        model.addAttribute("appName", "Список покупок");
        model.addAttribute("item", itemService.listAllItems());
        return "shopping-list";
    }
}
