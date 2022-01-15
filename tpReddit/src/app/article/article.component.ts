import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Article } from '../article.model';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  @Output()
  deleteArticleEvent = new EventEmitter();
  @Input()
  article: Article = new Article('tmp', 'link');
  updateOn: boolean = false;
  selectedArticle: Article = new Article('tmp', 'link');;
  constructor() { }

  voteUp(): boolean {
    this.article.voteUp();
    return false;
  }
  voteDown(): boolean {
    this.article.voteDown();
    return false;
  }


  deleteArticle(id:number){
    this.deleteArticleEvent.emit(id);
  }

  edit(){
    this.updateOn =true;
  }

  updateArticle(title: HTMLInputElement, link: HTMLInputElement, id: number) {
    console.log(`editing ${title} id ${id}`);
    this.article.title=title.value;
    this.article.link=link.value;
    // const a = new Article(title.value, link.value, 1);
    // a.id = id;
    // this.service.updateArticle(a).subscribe(
    //   data => {
    //     this.getArticles();
    //   }

    //);
    this.updateOn = false;
  }
  ngOnInit() {
  }

}
