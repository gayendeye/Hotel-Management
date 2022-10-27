import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Room } from '../model/room';
import { RoomService } from '../services/room.service';

@Component({
  selector: 'app-createroom',
  templateUrl: './createroom.component.html',
  styleUrls: ['./createroom.component.css']
})
export class CreateroomComponent implements OnInit {

  form !:   FormGroup;

  rooms : Room = new Room();
   
  room!: Room[];

  constructor( public roomService : RoomService,
  private router : Router) { }

  ngOnInit(): void { 
    this.form = new FormGroup({
    name : new FormControl('', [Validators.required]),
    numberRoom : new FormControl('', [Validators.required]),
    status : new FormControl('', [Validators.required]),
    telRoom : new FormControl('', [Validators.required]),
    image : new FormControl('', [Validators.required]),
    description : new FormControl('', [Validators.required]),
    maxCapacity : new FormControl('', [Validators.required]),
  });

}


get r (){
  return this.form.controls;
}

submit(){
  console.log(this.form.value);
  this.roomService.creatRoom(this.form.value).subscribe((res: any)=>{
    console.log('Room created successfully!');
    alert("Room create avec Successfully");
    this.router.navigateByUrl('/room');
  })
}


public createroom(){
  try{
    this.roomService.createRoom(this.rooms).subscribe((Response) =>{
      console.log("Create Succesfully " , Response)
    })
  }catch(error){
    throw error;

  }
}

}
