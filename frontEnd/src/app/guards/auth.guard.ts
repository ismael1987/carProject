import { Injectable } from "@angular/core";
import { AuthenticationService } from "../services/authetication.service";
import { CanActivate,Router } from "@angular/router";

@Injectable({
    providedIn: 'root'
})

export class AuthGuard implements CanActivate {
    constructor(private authService: AuthenticationService, private router: Router){

    }

    canActivate(){
        if(this.authService.isLoggedIn()) {
            this.router.navigate(["/cars"])
        }
        return !this.authService.isLoggedIn();
    }
}