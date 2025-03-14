import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AstTypeEditComponent } from './ast-type-edit.component';

describe('AstTypeEditComponent', () => {
  let component: AstTypeEditComponent;
  let fixture: ComponentFixture<AstTypeEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AstTypeEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AstTypeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
