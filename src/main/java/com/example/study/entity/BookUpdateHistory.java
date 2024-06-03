package com.example.study.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "book_update_history")
public class BookUpdateHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @Column(name="prev_name")
    private String prevName;

    @Column(name = "prev_price")
    private String prevPrice;

    @Column(name = "new_name")
    private String newName;

    @Column(name = "new_price")
    private long newPrice;

    @Column (name = "at")
    private LocalDateTime at;
}
