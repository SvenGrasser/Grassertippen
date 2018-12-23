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
import { MemberDetailsService } from './shared/member-details.service';
import { MemberDetailsComponent } from './member-details/member-details.component';

import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { LinksComponent } from './links/links.component';
import { ImpressumComponent } from './impressum/impressum.component';

@NgModule({
  declarations: [
    AppComponent,
    TournamentComponent,
    MemberSummaryComponent,
    TournamentWinnerComponent,
    MemberDetailsComponent,
    LinksComponent,
    ImpressumComponent,      
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule, 
    Ng2SearchPipeModule
  ],
  providers: [TournamentWinnerService, TournamentService, MemberSummaryService, MemberDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
