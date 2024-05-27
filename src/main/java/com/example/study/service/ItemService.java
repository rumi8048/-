package com.example.study.service;


import com.example.study.entity.Item;

import com.example.study.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
@Service
public class ItemService {
    private static ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public static long addItem(@Valid Item items){
        Item item = Item.builder()
                .id(items.getId())
                .name(items.getName())
                .description(items.getDescription())
                .startingPrice(items.getStartingPrice())
                .build();
        Item saved = itemRepository.save(items);
        return saved.getId();
    }
}
