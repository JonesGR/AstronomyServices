import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ast_typeListComponent } from './ast_type-list.component';

describe('AstTypeListComponent', () => {
  let component: Ast_typeListComponent;
  let fixture: ComponentFixture<Ast_typeListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Ast_typeListComponent]
    });
    fixture = TestBed.createComponent(Ast_typeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
