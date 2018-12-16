import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { MemberDetails } from '../shared/memberDetails';

@Injectable()
export class MemberDetailsService {
  constructor(private http: Http) {
  }

  public getMemberDetail(id: number): Observable<MemberDetails[]> {
    let url = 'http://localhost:8080/tippspiel/api/v1/members/' + id;
    console.log(this.http.get(url)
    .map((resp: Response) => resp.json()));
    return this.http.get(url)
      .map((resp: Response) => resp.json());
  }
}
