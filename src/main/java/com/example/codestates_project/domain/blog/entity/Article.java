package com.example.codestates_project.domain.blog.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id", updatable = false)
    private Long id;

    @Column(name = "article_title", nullable = false)
    private String title;

    @Column(name = "article_content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "article_created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "article_updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Entity 수정
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
