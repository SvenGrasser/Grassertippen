import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { TournamentComponent } from './tournament/tournament.component';
import { TournamentService } from './shared/tournament.service';

import { MemberSummaryComponent } from './member-summary/member-summary.component';
import { MemberSummaryService } from './shared/member-summary.service';

import { AppRoutingModule } from './app-routing/app-routing.module';
  

@NgModule({
  declarations: [
    AppComponent,
    TournamentComponent,
    MemberSummaryComponent    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [TournamentService, MemberSummaryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
