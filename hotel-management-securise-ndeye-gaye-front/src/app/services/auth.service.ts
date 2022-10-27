import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const api = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLogin = false;

  constructor(private http : HttpClient) { }

  login(username: string, password: string): Observable<any>{
    return this.http.post( api + 'signin', { username, password }, httpOptions);
  }

register(username: string , email: string , password: string): Observable<any>{
  return this.http.post(api + 'signup',{username,email,password},httpOptions);
}

logout(): Observable<any> {
  return this.http.post(api + 'signout', { }, httpOptions);
}
}
