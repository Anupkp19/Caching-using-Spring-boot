package com.example.assingment4.Repository;

import com.example.assingment4.Dto.Book;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface RedisRepository {
    void saveBook(Book emp);
    Book getOneBook(Integer id);

    Integer getOneBookByTitle(String title);
    Integer getOneBookByAuthor(String name);
    Book updateBook(Book emp);
    Map<Integer, Book> getAll();
    void deleteBook(Integer id);
    void saveAllBook(Map<Integer, Book> map);

}
