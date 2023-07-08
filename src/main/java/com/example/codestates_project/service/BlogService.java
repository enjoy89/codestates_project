package com.example.codestates_project.service;

import com.example.codestates_project.domain.blog.entity.Article;
import com.example.codestates_project.domain.blog.repository.BlogRepository;
import com.example.codestates_project.web.dto.blog.AddArticleRequestDto;
import com.example.codestates_project.web.dto.blog.UpdateArticleRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    // create
    public Article save(AddArticleRequestDto requestDto) {
        return blogRepository.save(requestDto.toEntity());
    }

    // read All
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // read only one
    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("article does not exist : " + id));
    }

    // delete
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    // update
    public Article update(Long id, UpdateArticleRequestDto requestDto) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("article does not exist : " + id));

        // 실제 객체가 업데이트 되는 것은 엔티티에서 정의
        // 서비스로직에서는 이를 명시해주는 용도
        article.update(requestDto.getTitle(), requestDto.getContent());
        return article;
    }
}
