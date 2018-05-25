import {BrowserModule} from '@angular/platform-browser';
import {NgModule, OnInit, APP_INITIALIZER} from '@angular/core';
import {KeycloakService, KeycloakAngularModule} from 'keycloak-angular';
import {initializer} from './app-init';
import {CardsService} from './cards.service';
import {FruitsService} from './fruits.service';
import {HttpClientModule} from '@angular/common/http';

import {GiphyService} from './giphy/giphy.service';
import {AppComponent} from './app.component';
import {CardListComponent} from './card-list/card-list.component';
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatGridListModule} from '@angular/material/grid-list';


@NgModule({
  declarations: [
    AppComponent,
    CardListComponent
  ],
  imports: [
    KeycloakAngularModule,
    BrowserModule, HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,

    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatGridListModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      multi: true,
      deps: [KeycloakService]
    },
    CardsService,
    FruitsService,
    GiphyService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
