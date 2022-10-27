import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from '../model/room';
import { RoomService } from '../services/room.service';

@Component({
  selector: 'app-viewroom',
  templateUrl: './viewroom.component.html',
  styleUrls: ['./viewroom.component.css']
})
export class ViewroomComponent implements OnInit {

  roomId !: number;
  room !: Room;


  constructor(    public roomService: RoomService,

    private route: ActivatedRoute,

    private router: Router) { }

  ngOnInit(): void {

    this.roomId = this.route.snapshot.params['roomId'];
    this.roomService.findRoomById(this.roomId).subscribe((data: Room)=>{
      this.room = data;
    })
  }

}
