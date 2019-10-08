import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { CarouselComponent } from 'ngx-carousel-lib';
import { Car } from '../common/car';
import { User } from '../common/user';
import { isNullOrUndefined, isNull } from 'util';
import { CarService } from '../services/car.service';
import { RentCarRequest } from '../common/rent_car_request';
import { MatSnackBar, MatSelect, MatSelectChange, MatOption, MatStepper } from '@angular/material';
import { AuthenticationService } from '../services/authetication.service';

@Component({
  selector: 'app-car-booking',
  templateUrl: './car-booking.component.html',
  styleUrls: ['./car-booking.component.scss']
})
export class CarBookingComponent implements OnInit {

  @ViewChild('topCarousel')
  topCarousel: CarouselComponent;

  @ViewChild('currencySelect')
  currencySelect: MatSelect;


  @ViewChild("stepper")
  stepper: MatStepper;

  @Input()
  cars: Car[];

  public degree: number = 20;
  public moreSlides: number = 3;
  public selected_car: Car;
  selected_from_date: Date;
  selected_to_date: Date;
  selected_currency: string;

  constructor(private car_rental: CarService, private snackBar: MatSnackBar, private auth: AuthenticationService) { }

  ngOnInit() {
  }

  prev() {
    this.topCarousel.slidePrev();
  }

  next() {
    this.topCarousel.slideNext();
  }

  onSelected(car: Car) {
    // In case a car is selected and you select a different car, the inital selection 
    // will perish and the new selection will take place
    if (!isNullOrUndefined(this.selected_car)) {
      if (!isNull(car)) {
        this.selected_car.toggle_selection();
      }
      this.selected_car.deselect();

    }
    this.selected_car = car;
  }

  book() {
    if (!isNull(this.selected_car) 
      && !isNullOrUndefined(this.selected_from_date)
      && !isNullOrUndefined(this.selected_to_date) 
      && !isNullOrUndefined(this.selected_currency)
      && !isNullOrUndefined(this.currencySelect.value)) {
        if (new Date(this.selected_from_date) > new Date(this.selected_to_date)) {
          this.openSnackBar("Check the date", "Close");
        }
      else {
        let request = new RentCarRequest(this.currencySelect.value, new Date(this.selected_from_date), new Date(this.selected_to_date), 
        this.auth.loggedInUser.user_id, this.selected_car.car_id);
        this.car_rental.PutRent(request);
        var index = this.cars.indexOf(this.cars.filter(x => x.car_id == this.selected_car.car_id)[0]);
        this.cars.splice(index, 1);
        this.topCarousel.update();
        this.openSnackBar("All good", "Close");
      }
    }
    else {
      this.openSnackBar("Something is terribly wrong", "Close");
    }
  }

  onSelectedFromDate(date: Date) {
    this.selected_from_date = date;
    this.stepper.next();
  }

  onSelectedToDate(date: Date) {
    this.selected_to_date = date;
    console.log("to");
    
    this.stepper.next();
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  selected(event: MatSelectChange) {
    const selectedData = {
      text: (event.source.selected as MatOption).viewValue,
      value: event.source.value
    }
    this.selected_currency = selectedData.value;
  }
}
