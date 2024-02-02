package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface ArticleRepository extends CrudRepository<Article,Long> {
    @Override
    List<Article> findAll();
}
