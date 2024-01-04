package com.example.assingment4.Repository;

import com.example.assingment4.Dto.Book;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Cacheable
public class RepositoryImpl implements RedisRepository{

    private final String hashReference = "Book";

    @Resource(name = "redisTemplate")
    private HashOperations<String, Integer, Book> hashOperations;

    public RepositoryImpl(RedisTemplate<String, Book> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void saveBook(Book emp) {
        hashOperations.put(hashReference, emp.getId(), emp);
    }

    @Override
    public Book getOneBook(Integer id) {
        return hashOperations.get(hashReference, id);
    }

    @Override
    public Integer getOneBookByTitle(String title) {

        Map<Integer, Book> bookMap = hashOperations.entries("Book");

        for (Map.Entry<Integer, Book> entry : bookMap.entrySet()) {
            if (entry.getValue().getTitle().equals(title)) {
                return entry.getKey();
            }
        }
        return null;
    }
    public Integer getOneBookByAuthor(String name) {

        Map<Integer, Book> bookMap = hashOperations.entries("Book");

        for (Map.Entry<Integer, Book> entry : bookMap.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    @CachePut
    public Book updateBook(Book emp) {
        hashOperations.put(hashReference, emp.getId(), emp);
        return emp;
    }

    @Override
    public Map<Integer, Book> getAll() {
        return hashOperations.entries(hashReference);
    }

    @Override
    @CacheEvict
    public void deleteBook(Integer id) {
        hashOperations.delete(hashReference, id);
    }

    @Override
    public void saveAllBook(Map<Integer, Book> map) {
        hashOperations.putAll(hashReference, map);
    }
}
