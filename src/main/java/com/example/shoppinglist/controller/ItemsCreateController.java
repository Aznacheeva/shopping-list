package com.example.shoppinglist.controller;

import com.example.shoppinglist.repository.ItemRepository;
import com.example.shoppinglist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemsCreateController {
    @Autowired
    ItemService itemService;

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String getCreate(Model model) {
        return "create";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String doCreate(@ModelAttribute("text") String text) {
        itemService.create(text);
        return "redirect:/";
    }
}
