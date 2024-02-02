package com.example.firstproject.controller;

import com.example.firstproject.dto.articleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class articleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/form";
    }
    @PostMapping("/articles/create")
    public String createArticle(articleForm form){
        //System.out.println(form.toString());
        //logging
        log.info(form.toString());

        // DTO 저장 entity로 저장
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        // repository 를 DB에 저장
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());
        return "";

    }
    @GetMapping("/articles/articles")
    public String index(Model model) {
        // 1: 모든 Article을 가져온다!
        List<Article> articleEntityList = articleRepository.findAll();
        log.info(articleEntityList.toString());
        // 2: 가져온 Article 묶음을 뷰로 전달!
        model.addAttribute("articleList", articleEntityList);
        // 3: 뷰 페이지를 설정!
        return "articles/index";
    }

    @GetMapping("/articles/{id}") // 해당 URL요청을 처리 선언
    public String show(@PathVariable Long id, Model model) { // URL에서 id를 변수로 가져옴
        log.info("id = " + id);
        // 1: id로 데이터를 가져옴!
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2: 가져온 데이터를 모델에 등록!
        model.addAttribute("article", articleEntity);
        // 3: 보여줄 페이지를 설정!
        return "articles/show";
    }
}
