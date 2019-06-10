import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Tournament } from '../shared/tournament';

@Injectable()
export class TournamentService {
  constructor(private http: Http) {
  }

  public getTournaments(): Observable<Tournament[]> {
    let url = '/tippspiel/api/v1/tournaments';
    return this.http.get(url)
      .map((resp: Response) => resp.json());
  }
}
