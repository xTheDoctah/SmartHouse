import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './/app-routing.module';
import {MeteoComponent} from './meteo/meteo.component';
import {HomeTempComponent} from './home-temp/home-temp.component';


@NgModule({
  declarations: [
    AppComponent,
    MeteoComponent,
    HomeTempComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule {
}
