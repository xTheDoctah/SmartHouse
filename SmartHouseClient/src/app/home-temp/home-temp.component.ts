import { Component, OnInit } from '@angular/core';
import {Main} from '../main';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-home-temp',
  templateUrl: './home-temp.component.html',
  styleUrls: ['./home-temp.component.css']
})
export class HomeTempComponent implements OnInit {
  temp: Main = new Main();
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<Main>('http://localhost:8080/currenttemp?id=0')
      .subscribe(
        risposta => {
          this.temp = risposta;
        }
      );
  }

}
