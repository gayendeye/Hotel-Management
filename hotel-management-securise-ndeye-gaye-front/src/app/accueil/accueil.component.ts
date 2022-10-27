import { Component, OnInit } from '@angular/core';
import { Room } from '../model/room';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

room !: Room[];

  constructor() { }

  ngOnInit(): void {
  }

}
