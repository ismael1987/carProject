import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from '../common/car';
import { RentCarRequest } from '../common/rent_car_request';
import { Rental } from '../common/get_rentals_response';
import { GetUserInfoResponse } from '../common/get_user_info_response';
import { environment } from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }


  public GetCars(): Observable<Car[]> {

    return new Observable<Car[]>((observer) => {
      this.http.get<Car[]>("http://localhost:8080/v1/cars").subscribe(x => {
        observer.next(x);
        observer.complete();
      }, error => {
        observer.error(error);
        observer.complete();
      })
    })
  }

  public PutRent(request: RentCarRequest): any {
    this.http.post(environment.base_url + environment.rent_cars_method, request, environment.content_type_json).subscribe(x => {
      return x;
    }, error => {
      return error;
    })
    return null;
  }

  public GetUserInfo(username: string): Observable<GetUserInfoResponse> {
    return new Observable<GetUserInfoResponse>((observer) => {
      this.http.get<GetUserInfoResponse>(environment.base_url + environment.get_user_info_method + "/" + username).subscribe(x => {
        observer.next(x);
        observer.complete();
      }, error => {
        observer.error(error);
        observer.complete();
      })
    })
  }

  public GetRentals(userid: number): Observable<Rental[]> {
    return new Observable<Rental[]>((observer) => {
      this.http.get<Rental[]>(environment.base_url + environment.get_rentals_method + "/" + userid).subscribe(x => {
        observer.next(x);
        observer.complete();
      }, error => {
        observer.error(error);
        observer.complete();
      })
    })
  }

  public ReturnCar(id: number): Observable<string> {
    let return_options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      body: {
        rental_id: id.toString()
      }
    };

    return new Observable<any>((observer) => {
      this.http.delete(environment.base_url + environment.return_car_method, return_options).subscribe(x => {
        observer.next(x);
        observer.complete();
      }), error => {
        observer.error(error);
        observer.complete();
      }
    })
    
  }
}
