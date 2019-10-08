import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-map',
  styles: ['agm-map { height: 300px; /* height is required */ }'],
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss'],
 
})
export class MapComponent{
  zoom: number = 15;
  @Input() lat: number;
  @Input() lng: number;
  @Input() label: string;

}