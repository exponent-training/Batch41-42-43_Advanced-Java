import { Component } from '@angular/core';
import { Regsiter } from '../model/register.model';
import { RegisterService } from '../service/register.service';
import { Login } from '../model/login.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
constructor(private rgService: RegisterService){

}

  name = "Application";
   login = new Login();
   regsiter = new Regsiter();

   addingData(){
     console.log(this.login);
     console.log(this.regsiter);
    //this.rgService.registerData(this.login);
   }
}
