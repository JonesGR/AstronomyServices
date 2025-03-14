import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';

/**
 * Represents main navigation.
 */
@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  imports: [
    RouterLink
  ],
  standalone: true,
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

}
