package com.kps.orderbackend.service;

import com.kps.orderbackend.model.Item;
import com.kps.orderbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepository itemRepo;

    public Item findById(Long itemId) {
        return itemRepo.findById(itemId).get();
    }

    public Item create(Item item) {
        return itemRepo.save(item);
    }

    public Iterable<Item> findAll() {
        return itemRepo.findAll();
    }

    public void deleteItem(Long itemId){
        itemRepo.deleteById(itemId);
    };
}
