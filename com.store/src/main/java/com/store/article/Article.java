package com.store.article;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String link;
    private Integer votes;

    public Long getId() {
        return id;
    }

    public String getTitle() {return title;}

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Article() {
        super();
    }

    public Article(Long id, String title, String link, Integer votes) { //todo: Integer id
        super();
        this.id = id;
        this.title = title;
        this.link = link;
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", link=" + link + "]";
    }
}
