package com.store.controller;

import java.util.List;


import com.store.service.ArticleService;
import com.store.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.store.article.Article;
import com.store.persistence.IArticlePersistence;

/**
 * @author Marielle Macheal Rudolph
 *
 */

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)

@RestController
@RequestMapping("articles")
public class ArticleController {

	@Autowired
	ArticleService service;

	@GetMapping
	public List<Article> getAllArticle(){
		return service.getAllArticle();
	}
	
	@GetMapping("/{id}")
    public Article findArticleById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

	@PostMapping
	public Article addArticle(@RequestBody Article article) {
		return service.addArticle(article);
	}
	
	@PutMapping(value = "/{id}")
	public Article editArtticle(@PathVariable("id") Long id,@RequestBody Article article) {

		return service.editArticle(id, article) ;
	}

	@DeleteMapping(value = {"/{id}"})
	public boolean deleteArticle(@PathVariable("id") Long id){
		return service.delete(id);
	}
}