package com.example.study.repository;

import com.example.study.entity.BookUpdateHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookUpdateHistoryRepository extends JpaRepository<BookUpdateHistory,Long> {
}
