import { Component, OnInit } from '@angular/core';
import {DawgService} from '../service/dawg.service';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'app-dawg-list',
  templateUrl: './dawg-list.component.html',
  styleUrls: ['./dawg-list.component.css']
})
export class DawgListComponent implements OnInit {
   getData: any = [];
  constructor(private dawgService: DawgService) { }

 

  getDawglist(){
    this.dawgService.getdawg().subscribe(
      data => this.getData = data
    )
  }

  ngOnInit(): void {
    this.getDawglist();
  }

}
