package com.ms.ordermanagement.consumer;

import com.ms.ordermanagement.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="BOOK-MANAGEMENT-SERVICE")
public interface BookConsumer {

    @GetMapping("/books")
    public String getBooks();

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id);

}
