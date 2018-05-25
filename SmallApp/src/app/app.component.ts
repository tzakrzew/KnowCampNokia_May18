import { Component, OnInit } from '@angular/core';
import {KeycloakService, KeycloakAngularModule} from 'keycloak-angular';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  isAuthenticated: boolean;

  constructor(private keyService: KeycloakService) {
  }

  async ngOnInit() {
    this.isAuthenticated = await this.keyService.isLoggedIn();
  }
}
