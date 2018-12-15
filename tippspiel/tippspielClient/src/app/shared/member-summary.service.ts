import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { MemberSummary } from '../shared/memberSummary';

@Injectable()
export class MemberSummaryService {
  constructor(private http: Http) {
  }

  public getMemberSummaries(): Observable<MemberSummary[]> {
    let url = 'http://localhost:8080/tippspiel/api/v1/members';
    console.log(this.http.get(url)
    .map((resp: Response) => resp.json()));
    return this.http.get(url)
      .map((resp: Response) => resp.json());
  }
}
