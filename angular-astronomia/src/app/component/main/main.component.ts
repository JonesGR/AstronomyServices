import { Component } from '@angular/core';
import {RouterOutlet} from '@angular/router';

/**
 * Represents main section.
 */
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  imports: [
    RouterOutlet
  ],
  standalone: true,
  styleUrls: ['./main.component.css']
})
export class MainComponent {

}
