package com.example.codestates_project.web.dto.blog;

import com.example.codestates_project.domain.blog.entity.Article;
import lombok.Getter;

@Getter
public class ArticleResponseDto {
    private String title;
    private String contnet;

    public ArticleResponseDto(Article article) {
        this.title = article.getTitle();
        this.contnet = article.getContent();
    }
}
