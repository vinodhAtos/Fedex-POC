import { Injectable } from '@angular/core';
import { HttpClient,HttpParams, HttpHeaders, HttpClientModule } from '@angular/common/http';
import {Observable} from 'rxjs';



@Injectable({
  providedIn: 'root'
})

export class DawgService {
  apiUrl = 'http://localhost:8080/api/';
  constructor(private http:HttpClient) { }


  postdawg(dawgdata:any) {
    return this.http.post(this.apiUrl + 'createDawg' , dawgdata);
 }

 getdawg(){
   return this.http.get(this.apiUrl + "getDawg");
 }

}
