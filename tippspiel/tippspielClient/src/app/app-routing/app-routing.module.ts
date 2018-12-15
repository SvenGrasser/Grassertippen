import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';


import { MemberSummaryComponent } from '../member-summary/member-summary.component';
import { TournamentWinnerComponent } from '../tournament-winner/tournament-winner.component';

const routes: Routes = [
  {
    path: '',
    component: MemberSummaryComponent
  },
  {
    path: 'tournaments',
    component: TournamentWinnerComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
