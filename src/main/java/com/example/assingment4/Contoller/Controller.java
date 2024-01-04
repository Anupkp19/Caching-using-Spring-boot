package com.example.assingment4.Contoller;


import com.example.assingment4.Dto.Book;
import com.example.assingment4.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;

@RestController
@Cacheable
@RequestMapping("/app/redis")
public class Controller {
    @Autowired
    private AuthorService service;
    //Long id= Long.valueOf(1);
    @GetMapping("/getall")
    public ResponseEntity<Map<Integer, Book>> get(){

        return new ResponseEntity<Map<Integer, Book>>(service.showAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public  ResponseEntity<String> adding(@RequestBody  Book b){
        System.out.println(b.toString());
        return new ResponseEntity<String>(service.addBook(b), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getone/{id}")
    public ResponseEntity<Book>  getone(@PathVariable("id") Integer id){
        return new ResponseEntity<Book>(service.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/getone/{title}/")
    public ResponseEntity<Book>  getingtitle(@PathVariable("title") String title){
        return new ResponseEntity<Book>(service.findByTitle(title), HttpStatus.ACCEPTED);
    }
    @GetMapping("getauthor/{name}/")
    public ResponseEntity<String>  getingname(@PathVariable("name") String name){
        return new ResponseEntity<String>(service.findByName(name), HttpStatus.ACCEPTED);
    }
    @PostMapping("/update")
    public  ResponseEntity<Book> appending(@RequestBody  Book b){
        System.out.println(b.toString());
        return new ResponseEntity<Book>(service.updating(b), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  getDelete(@PathVariable("id") Integer id){
        return new ResponseEntity<String>(service.deleting(id), HttpStatus.OK);
    }




}
