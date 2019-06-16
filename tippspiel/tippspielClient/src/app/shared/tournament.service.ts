import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Rx';
import { Tournament } from '../shared/tournament';

@Injectable()
export class TournamentService {
  constructor(private http: HttpClient) {
  }

  public getTournaments(): Observable<Tournament[]> {
    let url = '/tippspiel/api/v1/tournaments';
    return this.http.get<Tournament[]>(url);
  }
}
