import { Component } from '@angular/core';
import {AstTypeForm} from '../../../ast_type/model/ast_type-form';
import {CelestialBodies} from '../../model/celestial_bodies';
import {AstTypeService} from '../../../ast_type/service/ast-type.service';
import {CelestialBodyService} from '../../service/celestial-body.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CelestialBody} from '../../model/celestial_body';
import {CelestialBodyForm} from '../../model/celestial_body-form';

@Component({
  selector: 'app-celestial-body-view',
  standalone: false,

  templateUrl: './celestial-body-view.component.html'
})
export class CelestialBodyViewComponent {
  uuid: string | undefined;
  celestialBody: CelestialBodyForm | undefined;
  celestialBodies: CelestialBodies | undefined;


  constructor(
    private service: CelestialBodyService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getCelestialBody(params['uuid'])
        .subscribe(celestialBody => {
          this.uuid=celestialBody.id;
          this.celestialBody = {
            name: celestialBody.name,
            radius: celestialBody.radius,
            astType: celestialBody.astType.id
          };
        });

    });
  }

}
