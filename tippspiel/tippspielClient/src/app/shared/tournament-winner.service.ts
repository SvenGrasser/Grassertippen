import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Rx';
import { TournamentWinner } from '../shared/tournamentWinner';

@Injectable()
export class TournamentWinnerService {
  constructor(private http: HttpClient) {
  }

  public getTournamentWinners(): Observable<TournamentWinner[]> {
    let url = '/tippspiel/api/v1/tournamentWinners';
    return this.http.get<TournamentWinner[]>(url);
  }
}
