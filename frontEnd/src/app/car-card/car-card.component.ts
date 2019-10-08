import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Car } from '../common/car';

@Component({
  selector: 'app-car-card',
  templateUrl: './car-card.component.html',
  styleUrls: ['./car-card.component.scss']
})
export class CarCardComponent implements OnInit {

  constructor() { }

  @Input() car: Car;
  @Input() car_selected: Car;
  @Output() selected_car = new EventEmitter<Car>();

  ngOnInit() {
  }

  selected() {
    if (this.car.get_toggle()) {
      this.car.toggle_selection();
      this.car.selected_style = "";
      this.selected_car.emit(null);
    }
    else {
      this.car.toggle_selection();
      this.car_selected = this.car;
      this.car.selected_style = "selected";
      this.selected_car.emit(this.car);
    }
  }

  get_selected_style():string {
    return this.car.selected_style;
  }
}
