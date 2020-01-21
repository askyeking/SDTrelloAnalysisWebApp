import { TestBed } from '@angular/core/testing';

import { TrelloCsvFileServiceService } from './trello-csv-file-service.service';

describe('TrelloCsvFileServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TrelloCsvFileServiceService = TestBed.get(TrelloCsvFileServiceService);
    expect(service).toBeTruthy();
  });
});
