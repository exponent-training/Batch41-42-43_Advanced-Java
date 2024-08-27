import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

  //  headerDict = {
  //   'Content-Type': 'application/json',
  //   'Accept': 'application/json',
  //   'Access-Control-Allow-Headers': 'Content-Type',
  // }
  
  //  requestOptions = {                                                                                                                                                                                 
  //   headers: new Headers(this.headerDict), 
  // };
  //  httpHeaders: HttpHeaders = new HttpHeaders({
  //        'Content-Type': 'application/json',
  //        'Accept': 'application/json',
  //        'Access-Control-Allow-Headers': 'Content-Type',
  //        'Authorization': 'Bearer '+sessionStorage.getItem('token')
  //   });

    url = "http://localhost:9000/api/user";

  getUserData(){
    const options = {
      headers: {
        'content-type': 'application/json',
        Authorization: 'Bearer ' + sessionStorage.getItem('token')
      }
    };

    console.log("===== Header ====" +JSON.stringify(options));
    console.log("==== Token ==== : " +sessionStorage.getItem('token'));
    console.log("==== UserNumber ==== : " +sessionStorage.getItem('user'));

  return this.http.get(this.url+"/findUser/"+sessionStorage.getItem('user'),options);
}

}
