import { HttpClient } from '@angular/common/http';
import { Injectable} from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from './article.model';

@Injectable({
  providedIn: 'root'
})
@Injectable({
  providedIn: 'root'
})
export class HttpserviceService {
  constructor(private client:HttpClient) { }

  addArticle(strTitle: string, strLink: string){
    this.client.post<Article>('http://localhost:8080/articles/', {title: strTitle, link: strLink, votes : 10}).subscribe()
  }
  getArticles():Observable<Article[]>{
   return this.client.get<Article[]>('http://localhost:8080/articles/')
  }

  deleteArticle(id:number){
    this.client.delete<Article>(`http://localhost:8080/articles/${id}`).subscribe();
  }

  updateArticle(article:Article){

  }
}
