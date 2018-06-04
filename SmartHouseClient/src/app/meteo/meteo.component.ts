import {Component, OnInit} from '@angular/core';
import {Temperatura} from './MeteoDTO/temperatura';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-meteo',
  templateUrl: './meteo.component.html',
  styleUrls: ['./meteo.component.css']
})
export class MeteoComponent implements OnInit {
  tempo: Temperatura = new Temperatura();

  constructor(private http: HttpClient) {
  }

  ngOnInit() {

    this.http.get<Temperatura>('http://api.openweathermap.org/data/2.5/weather?zip=00128,IT&APPID=1bc26fa2e22f8e38030d246ebc0b767d')
      .subscribe(
        risposta => {
          this.tempo = risposta;
          this.tempo.main.temp = Math.trunc(this.tempo.main.temp - 273.15);
          this.tempo.main.temp_max = Math.trunc(this.tempo.main.temp_max - 273.15);
          this.tempo.main.temp_min = Math.trunc(this.tempo.main.temp_min - 273.15);
        }
      );
  }

}
