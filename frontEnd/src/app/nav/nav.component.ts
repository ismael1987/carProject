import { Component, OnInit,  } from '@angular/core';
import { isNullOrUndefined } from 'util';
import { AuthenticationService } from '../services/authetication.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  appTitle: string = 'CarRental';
  constructor(private auth: AuthenticationService) { }

  isLoggedIn: boolean;

  ngOnInit() {
    this.isLoggedIn = !isNullOrUndefined(this.auth.isLoggedIn());
    this.auth.navbar_visibility.subscribe(x => {
      this.isLoggedIn = x;
    })
  }

  logout() {
    this.auth.logout();
  }

}
