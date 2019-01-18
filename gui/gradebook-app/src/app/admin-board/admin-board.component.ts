import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-admin-board',
  templateUrl: './admin-board.component.html',
  styleUrls: ['./admin-board.component.css']
})
export class AdminBoardComponent implements OnInit {
  board: string;
  errorMessage: string;
  constructor(private userService: UserService) { }

  
    ngOnInit() {

      this.userService.getAdminBoard().subscribe(
        data => {
          this.board = data;
        },
        error => {
          this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
        }
      );
    }
  

}
