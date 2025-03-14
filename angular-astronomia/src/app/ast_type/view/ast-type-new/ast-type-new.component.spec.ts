import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AstTypeNewComponent } from './ast-type-new.component';

describe('AstTypeNewComponent', () => {
  let component: AstTypeNewComponent;
  let fixture: ComponentFixture<AstTypeNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AstTypeNewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AstTypeNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
