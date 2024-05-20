package com.example.study.controller.Item;

import com.example.study.controller.entity.Book;
import com.example.study.controller.entity.Item;
import com.example.study.repository.BookRepository;
import com.example.study.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }


    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }
}
