import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Main} from './main';
import {Temperatura} from './temperatura';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  temp: Main = new Main();
  tempo: Temperatura = new Temperatura();
  show: boolean;
  show1: boolean;

  constructor(private http: HttpClient) {

  }

  Invia() {
    this.temp.humidity = Math.floor(Math.random() * 100);
    this.temp.temp = Math.floor(Math.random() * 100);
    this.temp.pressure = Math.floor(Math.random() * 100);
    this.temp.temp_min = Math.floor(Math.random() * 100);
    this.temp.temp_max = Math.floor(Math.random() * 100);
    return this.http.post('http://localhost:8080/settemp', this.temp)
      .subscribe(

      );
  }

  Tempo() {

    if (this.show == null || this.show == false) {
      return this.http.get<Temperatura>('http://api.openweathermap.org/data/2.5/weather?zip=00128,IT&APPID=1bc26fa2e22f8e38030d246ebc0b767d')
        .subscribe(
          risposta => {
            this.tempo = risposta;
            this.tempo.main.temp = Math.trunc(this.tempo.main.temp - 273.15);
            this.tempo.main.temp_max = Math.trunc(this.tempo.main.temp_max - 273.15);
            this.tempo.main.temp_min = Math.trunc(this.tempo.main.temp_min - 273.15);
            this.show = true;
          }
        );
    } else {
      this.show = false;
    }

    //F = 1.8 * (K-273,15) +32.
    // K-273,15
  }

  currentTemp() {
    if (this.show1 == null || this.show1 == false) {
      return this.http.get<Main>('http://localhost:8080/currenttemp')
        .subscribe(
          risposta => {
            this.temp = risposta;
            this.show1 = true;
          }
        );
    } else {
      this.show1 = false;
    }

    //F = 1.8 * (K-273,15) +32.
    // K-273,15
  }
}
