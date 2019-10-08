import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { tap, mapTo, catchError, } from 'rxjs/operators';
import { User } from '../common/user';
import { of, Observable } from 'rxjs';
import { environment } from "../../environments/environment";

@Injectable({ providedIn: 'root' })
export class AuthenticationService {


    constructor(private http: HttpClient) {
    }

    public loggedInUser: User = null;
    navbar_visibility: EventEmitter<boolean> = new EventEmitter();


    login(username: string, password: string): Observable<boolean> {
        console.log("here")
        return this.http.put<User>(environment.base_url + environment.login_method, { username, password }, environment.content_type_json)
            .pipe(
                tap(user => {
                    this.doLoginUser(username, user.token, user.user_id);
                    this.navbar_visibility.emit(true);
                }),
                mapTo(true),
                catchError(error => {
                    this.navbar_visibility.emit(false);
                    return of(false);
                })
            );
    }

    doLoginUser(username: string, token: string, id: number) {
        this.loggedInUser = new User(username, token, id);
        this.storeUser(this.loggedInUser);
    }

    private storeUser(user: User) {
        localStorage.setItem(environment.local_storage_element_name, JSON.stringify(user));
    }

    isLoggedIn(): boolean {
        return !!this.getJwtToken();
    }

    getJwtToken(): User {
        return JSON.parse(localStorage.getItem(environment.local_storage_element_name)) as User;
    }

    logout() {
        this.navbar_visibility.emit(false);
        this.loggedInUser = null;
        this.removeUser();
    }

    private removeUser(){
        localStorage.removeItem(environment.local_storage_element_name);
    }
}