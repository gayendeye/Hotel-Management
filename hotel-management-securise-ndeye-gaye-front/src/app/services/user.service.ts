import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const api = 'http://localhost:8080/api/test/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}

  getPublicContent(): Observable<any> {
    return this.http.get(api + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(api + 'user', { responseType: 'text' });
  }
  
  getModeratorBoard(): Observable<any> {
    return this.http.get(api + 'wardens', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(api + 'admin', { responseType: 'text' });
  }
}
