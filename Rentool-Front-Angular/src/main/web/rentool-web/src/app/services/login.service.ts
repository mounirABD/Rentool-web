import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { User } from '../model/user.model';
import { map } from 'rxjs/operators';




@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(public http: Http) { }

  public login(user: User) {

    const headers = new Headers();

    headers.append('Access-Control-Allow-Origin', '*');
    const options = new RequestOptions();
    options.headers = headers;
    return this.http.get('http://localhost:8080/users', options);

  }

//  public register(user: User){
//    return this
//  }

}
