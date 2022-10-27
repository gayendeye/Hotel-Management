import { Component, OnInit } from '@angular/core';
import { Reservation } from '../model/reservation';
import { Room } from '../model/room';
import { ReservationService } from '../services/reservation.service';
import { RoomService } from '../services/room.service';

@Component({
  selector: 'app-datareservation',
  templateUrl: './datareservation.component.html',
  styleUrls: ['./datareservation.component.css']
})
export class DatareservationComponent implements OnInit {

  
  reservation !: Reservation[];

  reservations: Reservation = new Reservation();
  
 // numberRoom !: Room;

  reservationId !: number;

  roomId !: number;
  
  numberRoom !: string;

  constructor( private reservationService : ReservationService
    ,private serviceRoom : RoomService) { }

  ngOnInit(): void {
    this.reservationService.findAllReservation().subscribe(data =>{
      this.reservation = data;
    }),
    
    this.reservationService.findAllById(this.reservationId).subscribe(data =>{
      this.reservation = data;
    })

    this.reservationService.findRoomByNumberRoom(this.numberRoom).subscribe(data =>{
      this.reservation = data;
    }),

    this.serviceRoom.findRoomByNumberRoom(this.numberRoom).subscribe(data =>{
      this.reservation = data;
    })
  
  }



  public findreservation(){
    try{
    this.reservationService.findAllReservation().subscribe((Response) =>{
      console.log("Create Succesfully " , Response)
    })
    }catch(error){
      throw error;
    }
  }

  deleteRerservation(reservationId:number){
    this.reservationService.deleteReservation(reservationId).subscribe(res=>{
      this.reservation = this.reservation.filter(item=>item.reservationId!== reservationId);
      confirm("Voulez vous reellement supprimer?");
      console.log('Room delete successfully' , res)
    })
  }
  }


