import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CelestialBodyViewComponent } from './celestial-body-view.component';

describe('CelestialBodyViewComponent', () => {
  let component: CelestialBodyViewComponent;
  let fixture: ComponentFixture<CelestialBodyViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CelestialBodyViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CelestialBodyViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
