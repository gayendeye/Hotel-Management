import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Reservation } from '../model/reservation';
@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private api = "http://localhost:8080/api/test/reservation/"


  constructor(private httpclient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  //methode

  getAllReservation(): Observable<any> {
    return this.httpclient.get(this.api)
  }

  findAllReservation(): Observable<Reservation[]> {
    return this.httpclient.get<Reservation[]>(this.api, this.httpOptions);
  }

  findAllById(reservationId: number): Observable<Reservation[]> {
    return this.httpclient.get<Reservation[]>(this.api + reservationId, this.httpOptions);
  }

  createReservation(reservation: Reservation): Observable<Object> {
    return this.httpclient.post(this.api, JSON.stringify(reservation), this.httpOptions);
   // return this.httpclient.post(`${this.api}`, reservation);
  }

  updateReservation(post: any): Observable<any> {
    return this.httpclient.put<any>(this.api, this.httpOptions);
  }

  deleteReservation(reservationId: number): Observable<any> {
    return this.httpclient.delete<any>(this.api + reservationId, this.httpOptions)
  }


  findRoomByNumberRoom(numberRoom: string): Observable<any> {
    return this.httpclient.get(this.api + numberRoom)
  }
}