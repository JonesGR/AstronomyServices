import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CelestialBodyNewComponent } from './celestial-body-new.component';

describe('CelestialBodyNewComponent', () => {
  let component: CelestialBodyNewComponent;
  let fixture: ComponentFixture<CelestialBodyNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CelestialBodyNewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CelestialBodyNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
