package com.example.codestates_project.web.controller;

import com.example.codestates_project.domain.blog.entity.Article;
import com.example.codestates_project.service.BlogService;
import com.example.codestates_project.web.dto.blog.ArticleListViewResponseDto;
import com.example.codestates_project.web.dto.blog.ArticleViewResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class BlogViewController {

    private final BlogService blogService;

    // 게시글 조회
    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponseDto> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponseDto::new)
                .collect(Collectors.toList());

        model.addAttribute("articles", articles);
        return "articleList";
    }

    // 게시글 상세 조회
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleListViewResponseDto(article));
        return "article";
    }

    // 게시글 신규 등록과 수정을 동시에 처리
    // required = false -> id값이 null이어도 괜찮다.
    // id가 null이면 신규 등록, null이 아니면 수정 작업
    // 게시글 수정
    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if(id == null) {
            model.addAttribute("article", new ArticleViewResponseDto());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponseDto((article)));
        }
        return "newArticle";
    }

    @DeleteMapping("/articles/{id}")
    public String deleteArticle(@PathVariable Long id) {
        blogService.deleteById(id);
        return "articleList";
    }
}
