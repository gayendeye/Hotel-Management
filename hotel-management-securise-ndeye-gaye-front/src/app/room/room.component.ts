import { Component, OnInit } from '@angular/core';
import { Reservation } from '../model/reservation';
import { Room } from '../model/room';
import { ReservationService } from '../services/reservation.service';
import { RoomService } from '../services/room.service';
import { StorageService } from '../services/storage.service';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {

  rooms : Room = new Room();

  roomId !: number; 
  
  room!: Room[];
  
  reservation !: Reservation[];
  
  reservations: Reservation = new Reservation();

  numberRoom !: string;

  roles: string[] = [];

  isLoggedIn = false;
  showAdminBoard = false;

  p: number = 1;
  

  constructor(private storageService: StorageService ,private serviceRoom: RoomService,
    private reservationService : ReservationService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.storageService.isLoggedIn();
    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      this.roles = user.roles;
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
    }



    this.serviceRoom.getAllRoom().subscribe(data =>{
      this.room = data;
    }),

    this.serviceRoom.findRoomByNumberRoom(this.numberRoom).subscribe(data =>{
      this.reservation = data;
    })
  
  
    this.reservationService.findAllReservation().subscribe(data =>{
      this.reservation = data;
    }),

    this.serviceRoom.getAllRoom().subscribe((data : Room[])=>{
      this.room = data;
      console.log(this.rooms)
    });
  }
  deleteRoom(roomId:number){
    this.serviceRoom.deleteRoomById(roomId).subscribe(res=>{
      this.room = this.room.filter(item=>item.roomId!== roomId);
      alert("Voulez vous reellement supprimer?");
      console.log('Room delete successfully' , res)
    })
  }
  
  
  public createroom(){
    try{
      this.serviceRoom.createRoom(this.rooms).subscribe((Response) =>{
        console.log("Create Succesfully " , Response)
      })
    }catch(error){
      throw error;
  
    }
  }
  
  public createreservation(){
    try{
      this.reservationService.createReservation(this.reservations).subscribe((Response) =>{
        console.log("Create Succesfully " , Response)
      })
    }catch(error){
      throw error;
  
    }
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
  
  }
