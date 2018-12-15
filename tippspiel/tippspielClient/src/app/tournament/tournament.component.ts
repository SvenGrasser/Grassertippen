import { Component, OnInit } from '@angular/core';
import { TournamentService } from '../shared/tournament.service';
import { Tournament } from '../shared/tournament';
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-tournament',
  templateUrl: './tournament.component.html',
  styleUrls: ['./tournament.component.css']
})
export class TournamentComponent implements OnInit {
  tournaments: Observable<Tournament[]>;
  constructor(private tournamentService: TournamentService) { }

  ngOnInit() {    
    this.tournaments = this.tournamentService.getTournaments();
  }
}
