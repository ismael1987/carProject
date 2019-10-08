import { Component, OnInit, Input , Output, EventEmitter} from '@angular/core';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';

@Component({
  selector: 'app-date-picker',
  templateUrl: './date-picker.component.html',
  styleUrls: ['./date-picker.component.scss']
})
export class DatePickerComponent implements OnInit {

  constructor() { }

  @Input() placeholder: string;
  @Output() selected_date: EventEmitter<Date> = new EventEmitter<Date>();

  ngOnInit() {
    
  }

  addEvent(eventType: string, date: MatDatepickerInputEvent<Date> ) {
    this.selected_date.emit(date.value);
  }


}
