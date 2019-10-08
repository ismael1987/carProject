import { LoginComponent } from './login/login.component';
import { CarListComponent } from './car-list/car-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookedCarsComponent } from './booked-cars/booked-cars.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './guards/auth.guard';
import { GenericGuard } from './guards/generic.guard';

const routes: Routes = [
  { 
    path: '', 
    component: LoginComponent,
    canActivate: [AuthGuard]
  },
  { 
    path: 'login', 
    component: LoginComponent,
    canActivate: [AuthGuard]
  },
  { 
    path: 'bookings', 
    component: BookedCarsComponent, 
    canActivate: [GenericGuard]
  },
  { 
    path: 'list-cars', 
    component: CarListComponent,
    canActivate: [AuthGuard]
  },
  { 
    path: 'register', 
    component: RegisterComponent 
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
