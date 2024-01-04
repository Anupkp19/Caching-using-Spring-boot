package com.example.assingment4.Service;

import com.example.assingment4.Dto.Book;
import com.example.assingment4.Repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    RedisRepository repository;



    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public Map<Integer, Book> showAll() {
        return repository.getAll();
    }

    @Override
    public String addBook(Book book){
        try{
            String id = String.valueOf(book.getId());
            repository.saveBook(book);
           return "Book saved Successfully";

        }catch (Exception e){
            return e.getMessage();

        }
    }
    public Book getOne(Integer id){
            Book b = repository.getOneBook(id);
            return b;

    }

    public Book findByTitle(String title){
        Integer a =  repository.getOneBookByTitle(title);
        Book c = repository.getOneBook(a);
        return c;
    }
    public String findByName(String name){

        Integer a = repository.getOneBookByAuthor(name);
        Book c = repository.getOneBook(a);
        return "The Books that are Written By Author are " + c.getTitle();
    }

    public Book updating(Book emp){
        return repository.updateBook(emp);
    }

    public String deleting(Integer id){
         repository.deleteBook(Integer.valueOf(id));
        return "Successfully removed from caching";
    }



}