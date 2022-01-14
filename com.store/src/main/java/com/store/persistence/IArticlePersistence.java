package com.store.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.article.Article;

public interface IArticlePersistence extends JpaRepository<Article, Long>{

}
