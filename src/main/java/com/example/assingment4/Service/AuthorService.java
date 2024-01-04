package com.example.assingment4.Service;

import com.example.assingment4.Dto.Book;

import java.util.Map;


public interface AuthorService {


    Book findById(Long id);

    Map<Integer, Book> showAll();

    String addBook(Book book);

  //  String getName();
    String findByName(String name);
    Book findByTitle(String title);
    Book getOne(Integer id);
    String deleting(Integer id);
    Book updating(Book emp);
}
