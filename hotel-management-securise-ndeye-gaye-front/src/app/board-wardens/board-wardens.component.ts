import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-board-wardens',
  templateUrl: './board-wardens.component.html',
  styleUrls: ['./board-wardens.component.css']
})
export class BoardWardensComponent implements OnInit {

  content?: string;

  constructor(private userService : UserService) { }

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
    });
  }
}