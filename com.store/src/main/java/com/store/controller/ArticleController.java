/**
 * 
 */
package com.store.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.article.Article;
import com.store.persistence.IArticlePersistence;

/**
 * @author Marielle Macheal Rudolph
 *
 */
@CrossOrigin(origins = "", maxAge = 3600) //todo : remettre http://localhost:4200
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
	
	
	@PostMapping
	public void addArticle(@RequestBody Article article) {
		articlePersistence.save(article);
	}
}
