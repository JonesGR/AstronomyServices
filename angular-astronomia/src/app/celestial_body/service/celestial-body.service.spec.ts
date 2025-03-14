import { TestBed } from '@angular/core/testing';

import { CelestialBodyService } from './celestial-body.service';

describe('AstTypeService', () => {
  let service: CelestialBodyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CelestialBodyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
