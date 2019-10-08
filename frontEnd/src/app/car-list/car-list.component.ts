import { Component, OnInit } from '@angular/core';
import { CarService } from '../services/car.service';
import { Car } from '../common/car';
import {Router} from '@angular/router';
import { ifError } from 'assert';
import { isNullOrUndefined } from 'util';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.scss']
})
export class CarListComponent implements OnInit {

  constructor(private car: CarService, private router: Router) { }

  cars: Car[];

  ngOnInit() {
   
    if(!isNullOrUndefined(this.car)) {
      this.car.GetCars().subscribe(x => {
        this.cars = x.map(x => Object.assign(new Car(), x));
      });
    }
  }
}
