import { UserService } from './../services/user.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Routes } from '@angular/router';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { first } from 'rxjs/operators';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;

  constructor(
    private formBuilder: FormBuilder,
    private UserService: UserService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      first_name: ['', Validators.required],
      last_name: ['', Validators.required],
      username: ['', Validators.required],
      driver_license: ['', Validators.required],
      role: ['', Validators.required],
      age: ['', Validators.required],
      pwd: ['', [Validators.required, Validators.minLength(6)]]
    });
  }
  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }
    this.loading = true;
    this.loading = true;
    this.UserService.register(this.f.first_name.value, this.f.last_name.value,this.f.username.value,this.f.driver_license.value,this.f.role.value,this.f.age.value,this.f.pwd.value)
      .pipe(first())
      .subscribe(
        success => {
          if(success) 
          {
            this.router.navigate(["/cars"]);
          }
        });
  }
}