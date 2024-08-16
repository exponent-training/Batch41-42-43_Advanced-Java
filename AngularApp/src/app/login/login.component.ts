import { Component } from '@angular/core';
import { Login } from '../model/login.model';
import { LoginService } from '../service/login.service';
import { UserResponse } from '../model/useresponse.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
constructor(private loginService : LoginService,private router :Router){

}


 login = new Login();
 userResponse = new UserResponse();
 admin : string ='admin';
 patient : string ='patient';
 doctor : string ='doctor';
 userLogin(){
     this.loginService.login(this.login).subscribe((rs:any)=>{
        console.log(rs);
        this.userResponse = rs;
        if(this.userResponse.errorMsg == null){
          if(this.userResponse.rolename === this.admin){
              this.router.navigate(['/admin']);
          } else if(this.userResponse.rolename === this.patient){
            this.router.navigate(['/patient']);
          }
          else if(this.userResponse.rolename === this.doctor){
            this.router.navigate(['/doctor']);
          }
        } else{
           alert(this.userResponse.errorMsg);
        }
     });
}

}
