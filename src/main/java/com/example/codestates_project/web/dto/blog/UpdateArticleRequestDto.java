package com.example.codestates_project.web.dto.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticleRequestDto {
    private String title;
    private String content;
}
