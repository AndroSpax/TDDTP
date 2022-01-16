/**
 *
 */
package com.store.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.store.article.Article;
import com.store.persistence.IArticlePersistence;

/**
 * @author Marielle Macheal Rudolph
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("articles")
public class ArticleController {



    @Autowired
    IArticlePersistence articlePersistence;

    @GetMapping
    public List<Article> getAllArticle() {
		return articlePersistence.findAll();
    }

//	@GetMapping("/{id}")
//    public void findArticleById(@PathVariable("id") Long id) {
//        Article article=articlePersistence.findById(id).get();
//        System.out.println(article);
//    }

    @PostMapping
    public void addArticle(@RequestBody Article article) {
        articlePersistence.save(article);
    }

	@DeleteMapping(value = {"/{id}"})
	public void deleteArticle(@PathVariable("id") Long id){
		System.out.println("Article with id : " + id + " delete ");
		articlePersistence.deleteById(id);
	}
}