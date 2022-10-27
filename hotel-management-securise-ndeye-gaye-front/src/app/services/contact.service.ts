import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Contact } from '../model/contact';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private api = "http://localhost:8080/api/test/contact/"


  constructor(private httpclient : HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
}

//methode

findAll(): Observable<Contact[]>{
  return this.httpclient.get<Contact[]>(this.api , this.httpOptions);
}

createContact(contact : Contact) : Observable<Object>{
  return this.httpclient.post(this.api, JSON.stringify(contact), this.httpOptions);
}

updateContact(post : any):Observable<any>{
  return this.httpclient.put<any>(this.api, this.httpOptions);
}

// deleteByTelContact(telContact : string): Observable<any>{
//   return this.httpclient.delete<any>(this.api + telContact, this.httpOptions)
// }

deleteContact(contactId : number): Observable<any>{
  return this.httpclient.delete<any>(this.api + contactId, this.httpOptions)
}
}
