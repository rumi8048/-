package com.example.study.controller.Item;

import com.example.study.dto.Item.UpdateItemDTO;
import com.example.study.entity.Item;

import com.example.study.repository.ItemRepository;

import com.example.study.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    private ItemService itemService;

    public ItemController(ItemService itemService,ItemRepository itemRepository){
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<String> updateItem(@PathVariable Long id, @RequestBody UpdateItemDTO updateItemDTO) {
        try {
            itemService.updateItem(id, updateItemDTO);
            return ResponseEntity.ok("Item updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public Long  addItem(@RequestBody @Valid Item items){
        return itemService.addItem(items);
    }
}
