import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Reservation } from '../model/reservation';
import { Room } from '../model/room';
import { ReservationService } from '../services/reservation.service';
import { RoomService } from '../services/room.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  reservation !: Reservation[];

  reservations: Reservation = new Reservation();
  
  numberPerson !: number;
  
  room!: Room;
  
  rooms !: Room[];
  
  roomId !: number;
  
  form !: FormGroup;

  reservationId !: number;


  constructor( private reservationService : ReservationService,
    private roomService : RoomService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    
      this.form = new FormGroup({
        dateInn : new FormControl('', [Validators.required]),
        dateOut : new FormControl('', [Validators.required]),
        numberPerson : new FormControl('', [Validators.required]),
        room : new FormControl('', [Validators.required]),
      });


    this.reservationService.getAllReservation().subscribe(data =>{
      this.reservation = data;
    });

    this.roomService.getAllRoom().subscribe((response) => {
      this.rooms = response;
      console.log(response);
    })


    this.roomId = this.route.snapshot.params['roomId'];
    this.roomService.findRoomById(this.roomId).subscribe((data: Room)=>{
      this.room = data;
    });

  //   this.form = new FormGroup({
  //   dateInn : new FormControl('', [Validators.required]),
  //   dateOut : new FormControl('', [Validators.required]),
  //   numberPerson : new FormControl('', [Validators.required]),
   
  // });
  }

  get r (){
    return this.form.controls;
  }

  public createreservation(){

    try{
      this.reservations.room = this.room
      this.reservationService.createReservation(this.reservations).subscribe((response) =>{
        console.log("Create Succesfully " , response)
        
      });
    }catch(error){
      throw error;

    }
  }

  public findreservation(){
    try{
      this.reservationService.findAllReservation().subscribe((Response)=>{
        console.log("Update Successfully" , Response)
      })
    }catch(error){
      throw error;
    }
  }

  submit(){
    console.log(this.form.value);
    this.reservationService.createReservation(this.reservations).subscribe((Response) =>{
      console.log('Reservation created successfully!' ,Response);
      alert("Reservation create avec Successfully");
    })
    
    }

}
