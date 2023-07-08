package com.example.codestates_project.web.dto.blog;

import com.example.codestates_project.domain.blog.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleRequestDto {
    private String title;
    private String content;

    // Dto -> Entity
    // Entity는 오직 데이터베이스에 접근할 때만 값이 바뀐다.
    public Article toEntity() {
        return Article.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
