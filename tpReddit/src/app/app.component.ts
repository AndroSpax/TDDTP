import { Component, OnInit } from '@angular/core';
import { Article } from './article.model';
import { HttpserviceService } from './httpservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit{
  title = 'TPReddit';
  articles:Article[]=[];
  constructor(private service: HttpserviceService){}

  ngOnInit(): void {
    this.getArticles()
  }
  deleteArticle(id:number){
    console.log("artile on the way to be fucked : " + id ) //todo : a virer
    this.service.deleteArticle(id);
    this.getArticles();
    return false;
  }

  addArticle(title:HTMLInputElement, link:HTMLInputElement){
    this.service.addArticle(title.value,link.value);

  }

  sortedArticles():Article[]{
    return this.articles.sort( (a,b) => b.votes - a.votes  );
  }

  getArticles() {
    this.service.getArticles().subscribe( restArticles => {
      this.articles= restArticles;
    });
  }
}