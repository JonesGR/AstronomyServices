import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AstTypeService} from '../../../ast_type/service/ast-type.service';
import {ActivatedRoute, Router} from '@angular/router';
import {v4 as uuidv4} from 'uuid';
import {CelestialBodyService} from '../../service/celestial-body.service';

@Component({
  selector: 'app-celestial-body-new',
  standalone: false,

  templateUrl: './celestial-body-new.component.html',
})
export class CelestialBodyNewComponent implements OnInit{
  celestialBodyForm: FormGroup;
  uuid: string | undefined;

  constructor(
    private fb: FormBuilder,
    private service: CelestialBodyService,
    private at_service: AstTypeService,
    private router: Router,
    private route: ActivatedRoute) {
    this.celestialBodyForm = this.fb.group({
      name: [''],     // Pole dla nazwy obiektu
      radius: [null, Validators.min(0)],
      astType: ['']
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.uuid = params['uuid'];
      if (this.uuid) {
        this.celestialBodyForm.patchValue({
          astType: this.uuid
        });
      }
    });
  }

  onSubmit(): void {
    console.log('Button clicked');
    console.log('Form Value:', this.celestialBodyForm.value);
    if (this.celestialBodyForm.valid) {

      this.service.putCelestialBody(uuidv4()!, this.celestialBodyForm.value!)
        .subscribe(()=>this.router.navigate(['/celestial_bodies']));
    }
  }
}
