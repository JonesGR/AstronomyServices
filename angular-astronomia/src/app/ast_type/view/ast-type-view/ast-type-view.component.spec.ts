import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AstTypeViewComponent } from './ast-type-view.component';

describe('AstTypeViewComponent', () => {
  let component: AstTypeViewComponent;
  let fixture: ComponentFixture<AstTypeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AstTypeViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AstTypeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
