/**
 * 
 */
package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.article.Article;
import com.store.persistence.IArticlePersistence;

/**
 * @author Mariell Macheal Rudolph
 *
 */
@RestController
@RequestMapping("articles")
public class ArticleController {

	
	@Autowired
	IArticlePersistence articlePersistence;
	
	@GetMapping
	public List<Article> getAllArticle(){
		return articlePersistence.findAll();
	}
	
	@GetMapping("/{id}")
	public void findArticleById(@PathVariable("id") Long id) {
		Article article=articlePersistence.findById(id).get();
		System.out.println(article);
	}
	
}
