import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderComponent} from './component/header/header.component';
import {NavComponent} from './component/nav/nav.component';
import {MainComponent} from './component/main/main.component';
import {FooterComponent} from './component/footer/footer.component';
import { HttpClientModule } from "@angular/common/http";
import { Ast_typeListComponent } from './ast_type/view/ast_type-list/ast_type-list.component';
import {AstTypeService} from './ast_type/service/ast-type.service';
import { AstTypeNewComponent } from './ast_type/view/ast-type-new/ast-type-new.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AstTypeEditComponent } from './ast_type/view/ast-type-edit/ast-type-edit.component';
import { AstTypeViewComponent } from './ast_type/view/ast-type-view/ast-type-view.component';
import { CelestialBodyListComponent } from './celestial_body/view/celestial-body-list/celestial-body-list.component';
import { CelestialBodyNewComponent } from './celestial_body/view/celestial-body-new/celestial-body-new.component';
import { CelestialBodyEditComponent } from './celestial_body/view/celestial-body-edit/celestial-body-edit.component';
import { CelestialBodyViewComponent } from './celestial_body/view/celestial-body-view/celestial-body-view.component';

@NgModule({
  declarations: [
    AppComponent,
    Ast_typeListComponent,
    AstTypeNewComponent,
    AstTypeEditComponent,
    AstTypeViewComponent,
    CelestialBodyListComponent,
    CelestialBodyNewComponent,
    CelestialBodyEditComponent,
    CelestialBodyViewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderComponent,
    NavComponent,
    MainComponent,
    FooterComponent,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    AstTypeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
