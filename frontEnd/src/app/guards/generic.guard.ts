import { Injectable } from '@angular/core';
import { CanActivate, CanLoad, Router } from '@angular/router';
import { AuthenticationService } from '../services/authetication.service';

@Injectable({
  providedIn: 'root'
})
export class GenericGuard implements CanActivate, CanLoad {

  constructor(private authService: AuthenticationService, private router: Router) { }

  canActivate() {
    return this.canLoad();
  }

  canLoad() {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/login']);
      this.router.navigate(["/cars"])

    }
    return this.authService.isLoggedIn();
  }
}