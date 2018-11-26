import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/model/user.model';

@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  mydata: string;

  constructor(private loginservice: LoginService) { }

  ngOnInit() {
  }

  login(): void {
    const user = new User;
    user.username = this.email;
    user.password = this.password;

    this.loginservice.login(user).subscribe(data => {
        let users = data.json();
        console.log('result from login component : ' + JSON.stringify(users[0].id));
    });
  }

}
