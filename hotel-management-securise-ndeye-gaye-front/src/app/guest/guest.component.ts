import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Guest } from '../model/guest';
import { Reservation } from '../model/reservation';
import { Room } from '../model/room';
import { GuestService } from '../services/guest.service';
import { RoomService } from '../services/room.service';

@Component({
  selector: 'app-guest',
  templateUrl: './guest.component.html',
  styleUrls: ['./guest.component.css']
})
export class GuestComponent implements OnInit {

guest!: Guest[];

guests: Guest = new Guest();

form !:   FormGroup;

room !: Room;

rooms : Room = new Room();

rooo !: Room[];

roomId !: number;

reservation !: Reservation;


reservations : Reservation = new Reservation();


  constructor(private serviceGuest: GuestService , private router : Router
    ,private roomService : RoomService) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      firstName : new FormControl('', [Validators.required]),
      lastName : new FormControl('', [Validators.required]),
      email : new FormControl('', [Validators.required]),
      numberPhone : new FormControl('', [Validators.required]),
      address : new FormControl('', [Validators.required]),
      city : new FormControl('', [Validators.required]),
      country : new FormControl('', [Validators.required]),
      // room : new FormControl('', [Validators.required]),

    });

   this.roomService.getAllRoom().subscribe((res) => {
    this.rooo = res;
   })


    this.serviceGuest.findAll().subscribe(data =>{
      this.guest = data;
    });
  }


  get g (){
    return this.form.controls;
  }


  public createguest(){
    try{
      this.serviceGuest.createGuest(this.guests).subscribe((Response) => {
        console.log("Create successfully", Response);
      })
    }catch (error){
      throw error;
    }
  }
  get r (){
    return this.form.controls;
  }

  submit(){
  console.log(this.form.value);
  this.serviceGuest.createGuest(this.form.value).subscribe((res: any)=>{
    console.log('Room reserved successfully! Thank You');
    alert("Room reserved successfully! Thank You");
    this.router.navigateByUrl('/home');
  })
  
  }
}