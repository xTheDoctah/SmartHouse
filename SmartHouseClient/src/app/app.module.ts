import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClient,HttpClientModule} from '@angular/common/http'
import { AppComponent } from './app.component';
import { MeteoComponent } from './meteo/meteo.component';
import { TemperatureComponent } from './temperature/temperature.component';

@NgModule({
  declarations: [
    AppComponent,
    MeteoComponent,
    TemperatureComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
