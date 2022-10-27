import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Guest } from '../model/guest';
import { GuestService } from '../services/guest.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  form !:   FormGroup;
  
  guest!: Guest[];
  guests: Guest = new Guest();

  constructor(private serviceGuest: GuestService) { }

  ngOnInit(): void {


    this.form = new FormGroup({
      email : new FormControl('', [Validators.required]),
      
    }),

    this.serviceGuest.findAll().subscribe(data =>{
      this.guest = data;
    });
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
  
  }
  
