package com.example.shoppinglist.controller;

import com.example.shoppinglist.service.CheckmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckmarkController {
    @Autowired
    CheckmarkService checkmarkService;

    @ResponseBody
    @RequestMapping(path = "/item-bought/{id}", method = RequestMethod.POST)
    public void checkmark(@PathVariable("id") Long id) {
        checkmarkService.isDone(id);
    }
}
