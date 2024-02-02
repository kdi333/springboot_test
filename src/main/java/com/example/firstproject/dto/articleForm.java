package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class articleForm {

    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
