import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { TournamentWinner } from '../shared/tournamentWinner';

@Injectable()
export class TournamentWinnerService {
  constructor(private http: Http) {
  }

  public getTournamentWinners(): Observable<TournamentWinner[]> {
    let url = '/tippspiel/api/v1/tournamentWinners';
    console.log(this.http.get(url)
    .map((resp: Response) => resp.json()));
    return this.http.get(url)
      .map((resp: Response) => resp.json());
  }
}
