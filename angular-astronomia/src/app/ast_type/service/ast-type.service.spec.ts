import { TestBed } from '@angular/core/testing';

import { AstTypeService } from './ast-type.service';

describe('AstTypeService', () => {
  let service: AstTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AstTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
