import { Injectable } from '@angular/core';
import { Article } from './article.model';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor() { }


  getArticles():Article[]{
    return [
      new Article('service1', 'Link1', 2),
      new Article('service2', 'Link2', 1),
      new Article('service3', 'Link3', 5),
      new Article('service4', 'Link4', 1),

    ];
  }
}
