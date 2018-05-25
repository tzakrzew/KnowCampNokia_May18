import { Component, OnInit } from '@angular/core';
import { CardsService } from '../cards.service';
import { FruitsService } from '../fruits.service';
import { GiphyService } from '../giphy/giphy.service';
import { KeycloakService } from 'keycloak-angular';



@Component({
  selector: 'app-card-list',
  templateUrl: './card-list.component.html',
  styleUrls: ['./card-list.component.css']
})
export class CardListComponent implements OnInit {
  cards: Array<any>;
  fruits: Array<any>;
  username: string;
  roles: Array<any>;
  usergif: string;

  constructor(private cardsService: CardsService, private giphyService: GiphyService, private fruitsSerice: FruitsService,  private keycloakService: KeycloakService) { }

  ngOnInit() {
      this.cardsService.getAll().subscribe(data => {
            this.cards = data;
            for (const card of this.cards) {
              this.giphyService.get(card.name).subscribe(url => card.giphyUrl = url);
            }
          });
      this.fruitsSerice.getAll().subscribe(data => {
        this.fruits = data;
        for (const fruit of this.fruits) {
          this.giphyService.get(fruit.type).subscribe(url => fruit.giphyUrl = url);
        }
      });
      this.giphyService.get(this.keycloakService.getUsername()).subscribe(url => this.usergif = url);
      this.username = this.keycloakService.getUsername();
      this.roles = this.keycloakService.getUserRoles();
    }

}
