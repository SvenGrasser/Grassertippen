/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { MemberSummaryService } from './member-summary.service';

describe('MemberSummaryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MemberSummaryService]
    });
  });

  it('should ...', inject([MemberSummaryService], (service: MemberSummaryService) => {
    expect(service).toBeTruthy();
  }));
});
