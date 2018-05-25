import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CardsService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get('https://localhost:9070/getherocards');
  }
}
