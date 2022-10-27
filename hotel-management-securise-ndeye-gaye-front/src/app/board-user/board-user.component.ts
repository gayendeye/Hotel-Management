import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Guest } from '../model/guest';
import { Reservation } from '../model/reservation';
import { Room } from '../model/room';
import { GuestService } from '../services/guest.service';
import { ReservationService } from '../services/reservation.service';
import { RoomService } from '../services/room.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {

  guestId !: number;

  guest !: Guest[];

   room: Room = new Room();

  guests: Guest = new Guest();
  
  content?: string;

  form !: FormGroup;

  gues !: Guest;
  
  reservation: Reservation = new Reservation();

  // roomId !: number;

   numberRoom !: string;

  constructor(private userService : UserService, private guestService : GuestService,
    private route : ActivatedRoute,
 
    private router : Router,
    
    private reservationService : ReservationService,
    
    private serviceRoom : RoomService) { }

  ngOnInit(): void {
    this.userService.getAdminBoard().subscribe({
      next: data => {
        this.content = data;
      },
      error: err => {console.log(err)
        if (err.error) {
          this.content = JSON.parse(err.error).message;
        } else {
          this.content = "Error with status: " + err.status;
        }
      }
    }),



    this.serviceRoom.findRoomByNumberRoom(this.numberRoom).subscribe(data =>{
      this.room = data;
    })

    this.guestService.findGuestById(this.guestId).subscribe(data =>{
      this.guest = data;
    }),

    this.guestService.findAll().subscribe(data =>{
      this.guest = data;
    }),



    this.guestId = this.route.snapshot.params['guestId'];
    this.guestService.findGuestById(this.guestId).subscribe((data : Guest) =>{
      this.guests = data;
    })
  }

  get r(){
    return this.form.controls;
  }
}
