package com.example.study.service;


import com.example.study.dto.Item.UpdateItemDTO;
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

    public void updateItem(Long id, UpdateItemDTO updateItemDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        if (updateItemDTO.getPrice() != null && updateItemDTO.getPrice() > item.getStartingPrice()) {
            item.setStartingPrice(updateItemDTO.getPrice());
        } else if (updateItemDTO.getPrice() != null) {
            throw new IllegalArgumentException("New price must be greater than the current price");
        }

        if (updateItemDTO.getDescription() != null) {
            item.setDescription(updateItemDTO.getDescription());
        }

        itemRepository.save(item);
    }
}
