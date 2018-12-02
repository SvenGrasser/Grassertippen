import { Component, OnInit } from '@angular/core';
import { MemberSummaryService } from 'app/shared/member-summary.service';
import { MemberSummary } from 'app/shared/memberSummary';
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-member-summary',
  templateUrl: './member-summary.component.html',
  styleUrls: ['./member-summary.component.css']
})
export class MemberSummaryComponent implements OnInit {
  test: string = "B";
  memberSummaries: Observable<MemberSummary[]>;
  constructor(private memberSummaryService: MemberSummaryService) { }

  ngOnInit() {
    this.test = "A";
    this.memberSummaries = this.memberSummaryService.getMemberSummaries();
  }

}
