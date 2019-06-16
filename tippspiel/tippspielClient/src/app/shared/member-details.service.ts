import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { HttpClient } from '@angular/common/http';
import { MemberDetails } from '../shared/memberDetails';

@Injectable()
export class MemberDetailsService {
  constructor(private http: HttpClient) {
  }

  public getMemberDetail(id: number): Observable<MemberDetails[]> {
    let url = '/tippspiel/api/v1/members/' + id;
    return this.http.get<MemberDetails[]>(url);
  }
}
