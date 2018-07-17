package com.m1.news.controller;

import com.m1.news.domain.Intro;
import com.m1.news.domain.News;
import com.m1.news.repo.NewsRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class NewsController {
    private static final int NEWSNUM = 50;
    @Resource
    private NewsRepository newsRepository;

    @GetMapping("/intro")
    public List<Intro> getIntros(@RequestParam("page") int page, @RequestParam("num") int num,
                                 HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        int pageStartNum = (page - 1) * num;
        int pageEndNum = page * num;
        List<Intro> introList = new ArrayList<>();
        if (pageStartNum > NEWSNUM) {
            return introList;
        }
        int limitNum = pageEndNum < NEWSNUM ? pageEndNum : NEWSNUM;

        for (int i = pageStartNum + 1; i <= limitNum; i++) {
            News news = newsRepository.getNewsById(i + "");
            if (news == null) {
                continue;
            }
            introList.add(new Intro(news.getId(), news.getTitle(), news.getImages()));
        }
        return introList;
    }

    @GetMapping("/news")
    public News getNewsContent(@RequestParam("id") String id, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        return newsRepository.getNewsById(id);
    }

    @PostMapping("/news/add")
    public void addNews(@RequestBody News news) {
        newsRepository.addNews(news);
    }

    @PostMapping("/news/update")
    public void updateNews(@RequestBody News news, @RequestParam("id") String newsId) {
        news.setId(newsId);
        newsRepository.addNews(news);
    }

    @GetMapping("/news/all")
    public Object getAllNews() {
        return newsRepository.getAllNews();
    }


}
