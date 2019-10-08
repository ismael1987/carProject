import { MapComponent } from './map/map.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule }    from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatNativeDateModule, MatFormFieldModule, MatOptionModule, MatSelectModule, MatInputModule, MatCardModule, MatButtonModule, MatDatepickerModule, MatToolbarModule, MatProgressSpinnerModule, MatDividerModule, MatExpansionModule, MatIconModule, MatSnackBarModule} from '@angular/material';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarListComponent } from './car-list/car-list.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AgmCoreModule } from '@agm/core';
import { NavComponent } from './nav/nav.component';
import { CarouselModule} from "ngx-carousel-lib";
import { CarBookingComponent } from './car-booking/car-booking.component';
import { CarCardComponent } from './car-card/car-card.component';
import { DatePickerComponent } from './date-picker/date-picker.component';
import {FormsModule} from '@angular/forms';
import { BookedCarsComponent } from './booked-cars/booked-cars.component';
import { MatStepperModule } from '@angular/material/stepper';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { TokenInterceptor } from './interceptor/token.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    MapComponent,
    LoginComponent,
    RegisterComponent,
    NavComponent,
    CarBookingComponent,
    CarCardComponent,
    DatePickerComponent,
    BookedCarsComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatOptionModule,
    MatSelectModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatToolbarModule,
    MatProgressSpinnerModule,
    CarouselModule,
    MatDividerModule,
    MatExpansionModule,
    MatIconModule,
    MatSnackBarModule,
    ReactiveFormsModule,
    MatStepperModule,
    MatProgressBarModule,
    MatSelectModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyC9QLiLVfQEIxoY9r8OuGekxuYEJHplKjU'
    })
  ],
  providers: [
    { 
      provide: HTTP_INTERCEPTORS, 
      useClass: TokenInterceptor, 
      multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
