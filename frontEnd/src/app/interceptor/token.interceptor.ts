import { Injectable } from "@angular/core";
import {
    HttpRequest,
    HttpHandler,
    HttpEvent,
    HttpInterceptor,
    HttpResponse
  } from '@angular/common/http';
import { AuthenticationService } from "../services/authetication.service";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { Router } from "@angular/router";

@Injectable({ providedIn: 'root' })
export class TokenInterceptor implements HttpInterceptor {

    constructor(private auth: AuthenticationService, private router: Router) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if(this.auth.getJwtToken()){
            request = this.addToken(request, this.auth.getJwtToken().token);
        }
        return next.handle(request).pipe(catchError(error => {
            if(error.status === 401) {
                this.handle401Error();
            }
            else {
                return throwError(error);
            }
        }))
    }

    private addToken(request: HttpRequest<any>, token: string): HttpRequest<any>{
        return request.clone({
            setHeaders: {
                'X-API-KEY' : token 
            }
        });
    }

    private handle401Error() {
        this.auth.logout();
        this.router.navigate(["/login"]);
    }
}