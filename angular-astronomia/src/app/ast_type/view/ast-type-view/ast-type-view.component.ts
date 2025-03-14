import { Component } from '@angular/core';
import {AstTypeForm} from '../../model/ast_type-form';
import {AstTypeService} from '../../service/ast-type.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CelestialBodyService} from '../../../celestial_body/service/celestial-body.service';
import {CelestialBodies} from '../../../celestial_body/model/celestial_bodies';
import {AstType} from '../../model/ast_type';
import {CelestialBody} from '../../../celestial_body/model/celestial_body';

@Component({
  selector: 'app-ast-type-view',
  standalone: false,

  templateUrl: './ast-type-view.component.html'
})
export class AstTypeViewComponent {
  uuid: string | undefined;
  astType: AstTypeForm | undefined;
  celestialBodies: CelestialBodies | undefined;


  constructor(
    private service: AstTypeService,
    private cb_service: CelestialBodyService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getAstType(params['uuid'])
        .subscribe(astType => {
          this.uuid=astType.id;
          this.astType = {
            name: astType.name,
            avgSize: astType.avgSize
          };
          this.cb_service.getAstTypesCelestialBodies(this.uuid)
            .subscribe(celestialBodies => this.celestialBodies = celestialBodies)
        });

    });
  }
  onDelete(celestialBody: CelestialBody): void {
    this.cb_service.deleteCelestialBody(celestialBody.id).subscribe(() => this.ngOnInit());
  }

}
