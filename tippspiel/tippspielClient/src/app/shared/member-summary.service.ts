import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Rx';
import { MemberSummary } from './memberSummary';

@Injectable()
export class MemberSummaryService {
  constructor(private http: HttpClient) {
  }

  public getMemberSummaries(): Observable<MemberSummary[]> {
    let url = '/tippspiel/api/v1/members';
    return this.http.get<MemberSummary[]>(url);
  } 
}
