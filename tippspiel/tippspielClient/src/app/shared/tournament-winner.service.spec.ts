/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TournamentWinnerService } from './tournament-winner.service';

describe('TournamentWinnerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TournamentWinnerService]
    });
  });

  it('should ...', inject([TournamentWinnerService], (service: TournamentWinnerService) => {
    expect(service).toBeTruthy();
  }));
});
