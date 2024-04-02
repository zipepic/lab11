package com.example.lab11.service;

import com.example.lab11.model.Item;
import com.example.lab11.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(int id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public void updateItem(int id, Item item) {
        Item existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            item.setID(id);
            itemRepository.save(item);
        }
    }

    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
}

