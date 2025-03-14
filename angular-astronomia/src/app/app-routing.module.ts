import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Ast_typeListComponent} from './ast_type/view/ast_type-list/ast_type-list.component';
import {AppComponent} from './app.component';
import {AstTypeNewComponent} from './ast_type/view/ast-type-new/ast-type-new.component';
import {AstTypeEditComponent} from './ast_type/view/ast-type-edit/ast-type-edit.component';
import {AstTypeViewComponent} from './ast_type/view/ast-type-view/ast-type-view.component';
import {CelestialBodyListComponent} from './celestial_body/view/celestial-body-list/celestial-body-list.component';
import {CelestialBodyNewComponent} from './celestial_body/view/celestial-body-new/celestial-body-new.component';
import {CelestialBodyEditComponent} from './celestial_body/view/celestial-body-edit/celestial-body-edit.component';
import {CelestialBodyViewComponent} from './celestial_body/view/celestial-body-view/celestial-body-view.component';

const routes: Routes = [
  {
    component: AppComponent,
    path: "*"
  },
  {
    component: Ast_typeListComponent,
    path: "ast_types"
  },
  {
    component: AstTypeNewComponent,
    path: "ast_types/new"
  },
  {
    component: AstTypeEditComponent,
    path: "ast_types/:uuid/edit"
  },
  {
    component: AstTypeViewComponent,
    path: "ast_types/:uuid"
  },
  {
    component: CelestialBodyListComponent,
    path: "celestial_bodies"
  },
  {
    component: CelestialBodyNewComponent,
    path: "ast_types/:uuid/new"
  },
  {
    component: CelestialBodyEditComponent,
    path: "celestial_bodies/:uuid/edit"
  },
  {
    component: CelestialBodyViewComponent,
    path: "celestial_bodies/:uuid"
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
