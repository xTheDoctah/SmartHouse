import {Component, OnInit} from '@angular/core';
import {Main} from '../main';
import {HttpClient} from '@angular/common/http';
import {tempDTOS} from './tempDTOS';

@Component({
  selector: 'app-home-temp',
  templateUrl: './home-temp.component.html',
  styleUrls: ['./home-temp.component.css']
})
export class HomeTempComponent implements OnInit {
  temp: tempDTOS = new tempDTOS();

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get<Main>('http://localhost:8080/alltemps')
      .subscribe(
        risposta => {
          this.temp = risposta;
          console.log(this.temp.temperatureDTOS[2]);
        }
      );
  }

}
