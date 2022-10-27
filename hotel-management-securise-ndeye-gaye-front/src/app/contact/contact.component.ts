import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Contact } from '../model/contact';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contact !: Contact[];
  contacts : Contact = new Contact();

  constructor(private contactService : ContactService) { }

  form !:   FormGroup;

  ngOnInit(): void {

    this.form = new FormGroup({
      from : new FormControl('', [Validators.required]),
      to : new FormControl('', [Validators.required]),
      subject : new FormControl('', [Validators.required]),
      text : new FormControl('', [Validators.required]),
     
    });


    this.contactService.findAll().subscribe(data =>{
      this.contact = data;
    });
  }

  get c (){
    return this.form.controls;
  }
public createcontact(){
    try{
      this.contactService.createContact(this.form.value).subscribe((Response)=>{
        console.log("Create successfully", Response);
      })
    }catch(error){
      throw error;
    }
  }

  
}
