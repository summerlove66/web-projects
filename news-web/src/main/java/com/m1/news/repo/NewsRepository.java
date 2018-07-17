package com.m1.news.repo;

import com.m1.news.domain.News;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewsRepository {
    private RedisTemplate<String, News> newsRedisTemplate;
    private HashOperations hashOperations;
    private String hashKey = "NEWSAPP";

    public NewsRepository(RedisTemplate<String, News> newsRedisTemplate) {
        this.newsRedisTemplate = newsRedisTemplate;
        hashOperations = newsRedisTemplate.opsForHash();

    }

    public void addNews(News news) {
        newsRedisTemplate.opsForHash().put(hashKey, news.getId(), news);
    }

    public void updatNews(String id, News news) {
        newsRedisTemplate.opsForHash().put(hashKey, id, news);
    }

    public News getNewsById(String id) {
        return (News) newsRedisTemplate.opsForHash().get(hashKey, id);
    }

    public Object getAllNews() {
        return newsRedisTemplate.opsForHash().entries(hashKey);
    }
}
