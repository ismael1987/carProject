import { Component, OnInit, Input } from '@angular/core';
import { CarService } from '../services/car.service';
import { GetUserInfoResponse } from '../common/get_user_info_response';
import { Rental } from '../common/get_rentals_response';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material';
import { AuthenticationService } from '../services/authetication.service';

@Component({
  selector: 'app-booked-cars',
  templateUrl: './booked-cars.component.html',
  styleUrls: ['./booked-cars.component.scss']
})
export class BookedCarsComponent implements OnInit {

  constructor(private http: CarService,  private router: Router, private snackBar: MatSnackBar, private auth: AuthenticationService) { }

  rentals: Rental[];
  userinfo: GetUserInfoResponse;
  username: string = this.auth.getJwtToken().name;

  ngOnInit() {
    this.http.GetUserInfo(this.username).subscribe(x => {
      this.userinfo = x
      this.http.GetRentals(this.userinfo.id).subscribe(x => {
        this.rentals = x;
      });
    });
    
  }

  return(id: number){
    this.http.ReturnCar(id)
    .subscribe(success => {
      if(success) {
        var index = this.rentals.indexOf(this.rentals.filter(x => x.car_id === id)[0]);
        this.rentals.splice(index,1);
        this.openSnackBar("Car removed","Close");
      }
      
    });
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message,action, {
      duration: 2000,
    });
  }
}
