import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from '../model/room';
import { RoomService } from '../services/room.service';

@Component({
  selector: 'app-editroom',
  templateUrl: './editroom.component.html',
  styleUrls: ['./editroom.component.css']
})
export class EditroomComponent implements OnInit {

    roomId !: number;
    room !: Room;
    form !: FormGroup;
    rooms : Room = new Room();


  constructor(public roomService : RoomService,
    private route : ActivatedRoute,
    private router : Router) { }

  ngOnInit(): void {
    this.roomId = this.route.snapshot.params['roomId'];
    this.roomService.findRoomById(this.roomId).subscribe((data : Room) =>{
      this.room = data;
    });

    this.form = new FormGroup({
     
        roomId : new FormControl('', [Validators.required]),
        name : new FormControl('', [Validators.required]),
        numberRoom : new FormControl('', [Validators.required]),
        status : new FormControl('', [Validators.required]),
        telRoom : new FormControl('', [Validators.required]),
        image : new FormControl('', [Validators.required]),
        description : new FormControl('', [Validators.required]),
        maxCapacity : new FormControl('', [Validators.required]),
    });
  }

  get r(){
    return this.form.controls;
  }

  submit(){
    console.log(this.form.value);
    this.roomService.updatRoom(this.form.value).subscribe((res:any)=>{
      console.log("Room updated successufully!");
      this.router.navigateByUrl("/room");
    })
  }


  // public editroom(){
  //   try{
  //     this.roomService.updatRoom(this.rooms ).subscribe((Response) =>{
  //       console.log("Create Succesfully " , Response)
  //     })
  //   }catch(error){
  //     throw error;
  
  //   }
  // }

}
