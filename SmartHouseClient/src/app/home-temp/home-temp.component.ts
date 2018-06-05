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
  status = false;
  host = 'localhost';

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.testData();
  }

  requestData() {
    this.http.get<tempDTOS>('http://' + this.host + ':8080/alltemps')
      .subscribe(
        risposta => {
          this.temp = risposta;
          this.status = true;
        }
      );
  }

  testData() {
    this.http.get('http://' + this.host + ':8080/testdata')
      .subscribe(
      );
    this.requestData();
  }
}
