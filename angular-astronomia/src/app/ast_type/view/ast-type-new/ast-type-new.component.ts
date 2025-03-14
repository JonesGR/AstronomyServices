import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { v4 as uuidv4 } from 'uuid';
import {AstTypeService} from '../../service/ast-type.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-ast-type-new',
  standalone: false,

  templateUrl: './ast-type-new.component.html'
})
export class AstTypeNewComponent implements OnInit{
  astTypeForm: FormGroup;
  constructor(private fb: FormBuilder, private service: AstTypeService, private router: Router) {
    this.astTypeForm = this.fb.group({
      name: [''],     // Pole dla nazwy obiektu
      avgSize: [null, Validators.min(0)]
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log('Button clicked');
    console.log('Form Value:', this.astTypeForm.value);
    if (this.astTypeForm.valid) {

      this.service.putAstType(uuidv4()!, this.astTypeForm.value!)
        .subscribe(()=>this.router.navigate(['/ast_types']));
    }
  }
}

