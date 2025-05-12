import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpServiceService } from './http-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements HttpInterceptor {

  constructor(private http: HttpServiceService) { }
  
  intercept(req: HttpRequest<any>, next: HttpHandler) {

    if (localStorage.getItem('fname') && localStorage.getItem('token')) {

      // To modify an HttpRequest ,clone()
      req = req.clone({
        setHeaders: {
        "withCredentials" : "true",
        "name" : "Jayati",
          
          Authorization: this.http.getToken()
        }
      })
    }

    //interceptors transform the outgoing request before passing it to the next 
        //interceptor in the chain, by calling next.handle()
        console.log(req.headers.get("Authorization")+"------------------->>>")
    return next.handle(req);

  }

}