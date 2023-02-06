package com.kps.orderbackend.controller;

import com.kps.orderbackend.model.Item;
import com.kps.orderbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item create(@RequestBody Item item) {
        return itemService.create(item);
    }

    @GetMapping
    public Iterable<Item> findAll() {
        return itemService.findAll();
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId){

        System.out.println("entering delete item");
        itemService.deleteItem(itemId);
    }
}
