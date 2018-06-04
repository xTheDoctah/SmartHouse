import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {tempDTOS} from './HomeTempDTO/tempDTOS';

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
    this.http.get<tempDTOS>('http://localhost:8080/alltemps')
      .subscribe(
        risposta => {
          this.temp = risposta;
        }
      );
    this.testData();
  }

  testData() {
    this.http.get('http://localhost:8080/testdata')
      .subscribe(
      );

    this.http.get<tempDTOS>('http://localhost:8080/alltemps')
      .subscribe(
        risposta => {
          this.temp = risposta;
        }
      );
  }
}
