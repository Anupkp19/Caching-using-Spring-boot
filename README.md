1.Implemented a simple online bookstore application using Redis caching in Java Spring Boot.<br>
2.The application has the @CacheEvict annotation to invalidate the cache entries when a book or an author is created, updated, or deleted.<br>
3.The application has  the @CachePut annotation to update the cache entries when a book or an author is updated.<br>
4.The application uses the RedisCacheConfiguration class to set the TTL (timeto live) value for the cache entries to 10 minutes.<br>
5.The application uses the RedisCacheManagerBuilderCustomizer class to setthe cache names for the book and author caches to “books” and “authors”,respectively.<br>
