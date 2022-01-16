/**
 * 
 */
package com.store.controller;

import java.util.List;


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
	IArticlePersistence articlePersistence;
	
	@GetMapping
	public List<Article> getAllArticle(){
		return articlePersistence.findAll();
	}
	
	@GetMapping("/{id}")
    public Article findArticleById(@PathVariable("id") Long id) {
        Article article=articlePersistence.findById(id).get();
        System.out.println(article);
        return article;
    }

	@PostMapping
	public Article addArticle(@RequestBody Article article) {
		return articlePersistence.save(article);
	}
	
	@PutMapping(value = "/{id}")
	public Article editArtticle(@PathVariable("id") Long id,@RequestBody Article article) {
		//on récupère l'article avec son ID
		Article articleSQL = this.findArticleById(id);
		
		//on le remplit avec les nouvelle données
		articleSQL.setLink(article.getLink());
		articleSQL.setTitle(article.getTitle());
		articleSQL.setVotes(article.getVotes());		
		
		//on le persiste et le retourne
		return articlePersistence.save(articleSQL);
	}

	@DeleteMapping(value = {"/{id}"})
	public void deleteArticle(@PathVariable("id") Long id){
		articlePersistence.deleteById(id);
	}

}
