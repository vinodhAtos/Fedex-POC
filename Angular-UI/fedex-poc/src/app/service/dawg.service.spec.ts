import { TestBed } from '@angular/core/testing';

import { DawgService } from './dawg.service';

describe('DawgService', () => {
  let service: DawgService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DawgService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
