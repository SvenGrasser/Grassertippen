import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing/app-routing.module';

import { AppComponent } from './app.component';
import { TournamentComponent } from './tournament/tournament.component';
import { TournamentService } from './shared/tournament.service';

import { MemberSummaryComponent } from './member-summary/member-summary.component';
import { MemberSummaryService } from './shared/member-summary.service';

import { TournamentWinnerComponent } from './tournament-winner/tournament-winner.component';
import { TournamentWinnerService } from './shared/tournament-winner.service';

@NgModule({
  declarations: [
    AppComponent,
    TournamentComponent,
    MemberSummaryComponent,
    TournamentWinnerComponent    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [TournamentWinnerService, TournamentService, MemberSummaryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
