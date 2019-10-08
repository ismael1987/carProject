import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})

export class UserService {

  constructor(private http: HttpClient) { }
   //httpheader1= {headers: this.httpheader({'Content-Type':'application/json'})}
register(first_name : String,last_name: String,driver_license:String, username : string , pwd : string, age:number,role:number ) {
  return this.http.post( 'http://localhost:8080/v1/customer', { first_name,last_name,driver_license, username, pwd,age,role });
}
}