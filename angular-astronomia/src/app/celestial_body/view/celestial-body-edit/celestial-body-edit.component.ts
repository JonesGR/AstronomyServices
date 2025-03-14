import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CelestialBodyForm} from '../../model/celestial_body-form';
import {CelestialBodyService} from '../../service/celestial-body.service';

@Component({
  selector: 'app-celestial-body-edit',
  standalone: false,

  templateUrl: './celestial-body-edit.component.html'
})
export class CelestialBodyEditComponent {
  uuid: string | undefined;
  celestialBody: CelestialBodyForm | undefined;
  original: CelestialBodyForm | undefined;


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
          this.original= {...this.celestialBody};
        });
    });
  }

  onSubmit(): void {
    console.log('Button clicked');
    this.service.putCelestialBody(this.uuid!, this.celestialBody!)
      .subscribe(()=>this.router.navigate(['/celestial_bodies']))
  }
}
