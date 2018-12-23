import { Component, OnInit, Input } from '@angular/core';
import { MemberDetails } from '../shared/memberDetails';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-member-details',
  templateUrl: './member-details.component.html',
  styleUrls: ['./member-details.component.css'],
  inputs: ['memberDetails'],
})
export class MemberDetailsComponent implements OnInit {
  @Input() memberDetails: Observable<MemberDetails[]>;
  constructor() { }

  ngOnInit() {
  }
}
