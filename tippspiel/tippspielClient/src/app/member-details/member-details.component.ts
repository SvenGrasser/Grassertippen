import { Component, OnInit, Input } from '@angular/core';
import { MemberDetails } from '../shared/memberDetails';
import { Observable } from 'rxjs';
import { MemberSummary } from '../shared/memberSummary';

@Component({
  selector: 'app-member-details',
  templateUrl: './member-details.component.html',
  styleUrls: ['./member-details.component.css'],
  inputs: ['memberSummary', 'memberDetails'],
})
export class MemberDetailsComponent implements OnInit {
  @Input() memberSummary: MemberSummary;
  @Input() memberDetails: Observable<MemberDetails[]>;
  constructor() { }

  ngOnInit() {
  }
}
