import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CelestialBodyEditComponent } from './celestial-body-edit.component';

describe('CelestialBodyEditComponent', () => {
  let component: CelestialBodyEditComponent;
  let fixture: ComponentFixture<CelestialBodyEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CelestialBodyEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CelestialBodyEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
