import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { MemberSummaryService } from 'app/shared/member-summary.service';
import { MemberSummary } from '../shared/memberSummary';
import { MemberDetails } from 'app/shared/MemberDetails';
import { MemberDetailsService } from 'app/shared/member-details.service';

@Component({
  selector: 'app-member-summary',
  templateUrl: './member-summary.component.html',
  styleUrls: ['./member-summary.component.css']
})
export class MemberSummaryComponent implements OnInit {
  memberSummaries: Observable<MemberSummary[]>;
  selectedMemberSummary: MemberSummary;
  currentMemberDetails: Observable<MemberDetails[]>;
  constructor(private memberSummaryService: MemberSummaryService, private memberDetailsService: MemberDetailsService) { }

  ngOnInit() {
    this.memberSummaries = this.memberSummaryService.getMemberSummaries();
  }

  onSelect(memberSummary: MemberSummary): void {
    this.selectedMemberSummary = memberSummary;
    this.currentMemberDetails = this.memberDetailsService.getMemberDetail(this.selectedMemberSummary.id);
  }
}
