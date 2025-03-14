import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CelestialBodyListComponent } from './celestial-body-list.component';

describe('CelestialBodyListComponent', () => {
  let component: CelestialBodyListComponent;
  let fixture: ComponentFixture<CelestialBodyListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CelestialBodyListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CelestialBodyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
