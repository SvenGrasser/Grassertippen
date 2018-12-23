import { Component, OnInit, Input } from '@angular/core';
import { MemberSummary } from '../shared/memberSummary';

@Component({
  selector: 'app-member-details',
  templateUrl: './member-details.component.html',
  styleUrls: ['./member-details.component.css'],
  inputs: ['memberDetails'],
})
export class MemberDetailsComponent implements OnInit {
  @Input() memberSummary: MemberSummary;
  constructor() { }

  ngOnInit() {
  }
}
