import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Login } from '../model/login.model';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http : HttpClient) { }

  url = "http://localhost:9000/api/user";

  registerData(login:Login){
    console.log("Calling From RG component");
    console.log(login);

  //   const httpHeaders: HttpHeaders = new HttpHeaders({
  //     'Content-Type': 'application/json',
  //     'Accept': 'application/json',
  //     'Access-Control-Allow-Headers': 'Content-Type',
  //     'Autherization': 'Bearer '+sessionStorage.getItem('token')
  // });
    // return this.http.post(this.url+'/save',login,{headers:httpHeaders})
  return this.http.post(this.url+'/save',login);

  }
}
