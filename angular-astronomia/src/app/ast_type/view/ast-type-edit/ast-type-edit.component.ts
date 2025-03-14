import { Component } from '@angular/core';
import {AstTypeService} from '../../service/ast-type.service';
import {ActivatedRoute, Router} from '@angular/router';
import {v4 as uuidv4} from 'uuid';
import {AstTypeForm} from '../../model/ast_type-form';

@Component({
  selector: 'app-ast-type-edit',
  standalone: false,

  templateUrl: './ast-type-edit.component.html'
})
export class AstTypeEditComponent {
  uuid: string | undefined;
  astType: AstTypeForm | undefined;
  original: AstTypeForm | undefined;


  constructor(
    private service: AstTypeService,
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
          this.original= {...this.astType};
        });
    });
  }

  onSubmit(): void {
    console.log('Button clicked');
    this.service.putAstType(this.uuid!, this.astType!)
      .subscribe(()=>this.router.navigate(['/ast_types']))
  }
}
