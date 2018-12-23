import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { MemberSummaryService } from 'app/shared/member-summary.service';
import { MemberSummary } from '../shared/memberSummary';
import { MemberDetailsService } from 'app/shared/member-details.service';

@Component({
  selector: 'app-member-summary',
  templateUrl: './member-summary.component.html',
  styleUrls: ['./member-summary.component.css']
})
export class MemberSummaryComponent implements OnInit {
  memberSummaries: Observable<MemberSummary[]>;
  searchText: string;
  constructor(private memberSummaryService: MemberSummaryService, private memberDetailsService: MemberDetailsService) { }

  ngOnInit() {
    this.memberSummaries = this.memberSummaryService.getMemberSummaries();
  }

  onSelect(memberSummary: MemberSummary): void { 
    memberSummary.IsDetailsVisible = !memberSummary.IsDetailsVisible;
    if(memberSummary.MemberDetails == null) {
      memberSummary.MemberDetails = this.memberDetailsService.getMemberDetail(memberSummary.id);
    }
  }
}
