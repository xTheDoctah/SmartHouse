import {Routes} from '@angular/router';
import {MeteoComponent} from './meteo/meteo.component';
import {HomeTempComponent} from './home-temp/home-temp.component';

export const routes: Routes = [
  {path: 'meteo', component: MeteoComponent},
  {path: 'htemp', component: HomeTempComponent}
];
