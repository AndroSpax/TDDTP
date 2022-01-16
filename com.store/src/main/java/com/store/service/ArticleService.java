package com.store.service;

import com.store.article.Article;
import com.store.persistence.IArticlePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleService {


    @Autowired
    IArticlePersistence articlePersistence;

    //service: retourne la liste des article présente en base.
    public List<Article> getAllArticle() {
        return articlePersistence.findAll();
    }

    //service: cherche un article par son id
    public Article findById(Long id) {
        if (id != null) {
            return articlePersistence.findById(id).get();
        }
        return null;
    }

    //service : ajoute un article a condition que les champ soit conforme
    public Article addArticle(Article article) {
        if (article != null &&
                article.getId() == null &&
                article.getTitle() != null &&
                article.getLink() != null) {
            return articlePersistence.save(article);
        }
        return null;
    }

    public Article editArticle(Long id, Article article) {
        //on récupère l'article avec son ID
        Article articleSQL = this.findById(id);

        //on le remplit avec les nouvelle données
        if (articleSQL != null) {
            articleSQL.setLink(article.getLink());
            articleSQL.setTitle(article.getTitle());
            articleSQL.setVotes(article.getVotes());
            return articlePersistence.save(articleSQL);
        }
        return null;
    }

    //service: vérifie  que l'id soit pas null et présent dans la base avant suppression
    public boolean delete(Long id) {
        if (id != null) {
            if (findById(id) != null) {
                articlePersistence.deleteById(id);
                return true;
            }
        }
        return false;
    }

    //vérifie la validité des champs de l'article
    public boolean verifArticle() {
        return false;
    }


}


