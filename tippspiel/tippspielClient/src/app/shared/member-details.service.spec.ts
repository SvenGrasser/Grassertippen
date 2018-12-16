/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { MemberDetailsService } from './member-details.service';

describe('MemberDetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MemberDetailsService]
    });
  });

  it('should ...', inject([MemberDetailsService], (service: MemberDetailsService) => {
    expect(service).toBeTruthy();
  }));
});
