package com.example.codestates_project.web.controller.api;

import com.example.codestates_project.domain.blog.entity.Article;
import com.example.codestates_project.service.BlogService;
import com.example.codestates_project.web.dto.blog.AddArticleRequestDto;
import com.example.codestates_project.web.dto.blog.ArticleResponseDto;
import com.example.codestates_project.web.dto.blog.UpdateArticleRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BlogApiController {

    private final BlogService blogService;

    // create
    @PostMapping("/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(blogService.save(requestDto));
    }

    // read All
    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponseDto>> findAllArticles() {
        // Dto -> Entity
        List<ArticleResponseDto> articles = blogService.findAll()
                .stream().map(ArticleResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(articles);
    }

    // read only one
    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleResponseDto> findArticle(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(new ArticleResponseDto(blogService.findById(id)));
    }

    // update
    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequestDto requestDto) {
        Article updateArticle = blogService.update(id, requestDto);
        return ResponseEntity.ok().body(updateArticle);
    }

    // delete
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
