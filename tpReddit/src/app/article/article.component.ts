import {Component, OnInit, Input, EventEmitter, Output} from '@angular/core';
import {Article} from '../article.model';

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
  selectedArticle: Article = new Article('tmp', 'link');

  constructor() {
  }

  voteUp(): boolean {
    this.article.voteUp();
    return false;
  }

  voteDown(): boolean {
    this.article.voteDown();
    return false;
  }


  deleteArticle(id:number) {
    console.log("article to delete" + id);
    this.deleteArticleEvent.emit(id);
  }

  edit() {
    this.updateOn = true;
  }

  updateArticle(title: HTMLInputElement, link: HTMLInputElement, id: number) {
    console.log(`editing ${title} id ${id}`); //todo : console to remove
    this.article.title = title.value;
    this.article.link = link.value;
    this.updateOn = false;
  }

  ngOnInit() {
  }

}

