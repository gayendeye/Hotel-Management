import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Room } from '../model/room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private api = "http://localhost:8080/api/test/room/"


  constructor(private httpclient : HttpClient) { }

  
  httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
}



//other methode

getAllRoom(): Observable<any>{
  return this.httpclient.get(this.api)
}

creatRoom(room:Room): Observable<any>{
  return this.httpclient.post(this.api , JSON.stringify(room), this.httpOptions)
}

findRoomById(roomId:number): Observable<any>{
  return this.httpclient.get(this.api + roomId)
}

findRoomByNumberRoom(numberRoom:string): Observable<any>{
  return this.httpclient.get(this.api + numberRoom)
}


updatRoom(room:Room):Observable<any>{
  return this.httpclient.put(this.api , JSON.stringify(room), this.httpOptions)
}

deleteRoomById(roomId:number){
  return this.httpclient.delete(this.api + roomId, this.httpOptions)
}

//end methode



//methode

findAll(): Observable<Room[]>{
  return this.httpclient.get<Room[]>(this.api , this.httpOptions);
}

createRoom(room : Room) : Observable<Room>{
  return this.httpclient.post<Room>(this.api, JSON.stringify(room), this.httpOptions);
}

updateRoom(post : any):Observable<any>{
  return this.httpclient.put<any>(this.api, this.httpOptions);
}

deleteByTelRoom(telRoom : string): Observable<any>{
  return this.httpclient.delete<any>(this.api + telRoom, this.httpOptions)
}

deleteRoom(roomId : number): Observable<any>{
  return this.httpclient.delete<any>(this.api + roomId, this.httpOptions)
}

}


