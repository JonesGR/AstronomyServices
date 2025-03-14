import { Component, OnInit } from '@angular/core';
import { AstTypeService } from "../../service/ast-type.service";
import { AstTypes } from "../../model/ast_types";
import { AstType } from "../../model/ast_type";
import {Router} from '@angular/router';


@Component({
  selector: 'app-ast_type-list',
  templateUrl: './ast_type-list.component.html',
  standalone: false
})
export class Ast_typeListComponent implements OnInit {

  constructor(private service: AstTypeService) {}

  /**
   * Available ast_types.
   */
  astTypes: AstTypes | undefined;

  ngOnInit(): void {
    this.service.getAstTypes().subscribe(response => {
      console.log(response);
      this.astTypes = response;
    });

  }

  /**
   * Deletes selected ast_type.
   *
   * @param astType ast_type to be removed
   */
  onDelete(astType: AstType): void {
    this.service.deleteAstType(astType.id).subscribe(() => this.ngOnInit());
  }

}
