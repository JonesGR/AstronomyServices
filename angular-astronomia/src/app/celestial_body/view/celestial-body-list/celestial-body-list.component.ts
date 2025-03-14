import { Component } from '@angular/core';
import {AstTypes} from '../../../ast_type/model/ast_types';
import {CelestialBodies} from '../../model/celestial_bodies';
import {AstTypeService} from '../../../ast_type/service/ast-type.service';
import {CelestialBodyService} from '../../service/celestial-body.service';
import {AstType} from '../../../ast_type/model/ast_type';
import {CelestialBody} from '../../model/celestial_body';

@Component({
  selector: 'app-celestial-body-list',
  standalone: false,

  templateUrl: './celestial-body-list.component.html',
})
export class CelestialBodyListComponent {
  constructor(private service: CelestialBodyService) {}

  /**
   * Available celestial_bodies.
   */
  celestialBodies: CelestialBodies | undefined;

  ngOnInit(): void {
    this.service.getCelestialBodies().subscribe(response => {
      console.log(response);
      this.celestialBodies = response;
    });

  }

  /**
   * Deletes selected ast_type.
   *
   * @param astType ast_type to be removed
   */
  onDelete(celestialBody: CelestialBody): void {
    this.service.deleteCelestialBody(celestialBody.id).subscribe(() => this.ngOnInit());
  }
}
