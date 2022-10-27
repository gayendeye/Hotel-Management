import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Guest } from '../model/guest';


@Injectable({
  providedIn: 'root'
})
export class GuestService {

  private api = "http://localhost:8080/api/test/guest/"

  constructor(private httpclient : HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
}


//methode

findGuestById(guestId:number): Observable<any>{
  return this.httpclient.get(this.api + guestId)
}

findAll(): Observable<Guest[]>{
  return this.httpclient.get<Guest[]>(this.api , this.httpOptions);
}

createGuest(guest : Guest) : Observable<Object>{
  return this.httpclient.post(this.api, JSON.stringify(guest), this.httpOptions);
}

updateGuest(post : any):Observable<any>{
  return this.httpclient.put<any>(this.api, this.httpOptions);
}

// deleteByTelGuest(telGuest : string): Observable<any>{
//   return this.httpclient.delete<any>(this.api + telGuest, this.httpOptions)
// }

deleteBook(roomId : number): Observable<any>{
  return this.httpclient.delete<any>(this.api + roomId, this.httpOptions)
}

}