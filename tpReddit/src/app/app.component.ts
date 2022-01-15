import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Article } from './article.model';
import { ArticleService } from './article.service';
import { HttpserviceService } from './httpservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
//  providers: [ArticleService]
})
export class AppComponent implements OnInit{
  title = 'TPReddit';
  articles:Article[]=[];
  // constructor(private service:ArticleService){}
  constructor(private service: HttpserviceService){}


  ngOnInit(): void {
    // this.articles = this.service.getArticles();
    this.getArticles()
  }

  // deleteArticle(id:number){
  //   let removeMe = this.articles.findIndex( a => a.id == id);
  //   this.articles.splice(removeMe, 1);
  //   //alert(`copy that ${removeMe}`);
  // }

  deleteArticle(id:number){
    this.service.deleteArticle(id);
    this.getArticles();
  }


  // addArticle(title:HTMLInputElement, link:HTMLInputElement){
  //  this.articles.splice(0, 0, new Article(title.value, link.value));
  //  return false;
  //   this.articles.push(new Article(title.value, link.value));
  //   title.value = '';
  //   link.value = '';
  // }

  addArticle(title:HTMLInputElement, link:HTMLInputElement){
    this.service.addArticle(title.value,link.value);
    this.getArticles();
    return false;
  }

  sortedArticles():Article[]{
    return this.articles.sort( (a,b) => b.votes - a.votes  );
  }

  getArticles() {
    this.service.getArticles().subscribe( restArticles => this.articles= restArticles);
  }
}
