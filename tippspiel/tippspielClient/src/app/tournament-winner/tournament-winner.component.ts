import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { TournamentWinnerService } from '../shared/tournament-winner.service';
import { TournamentWinner } from '../shared/TournamentWinner';

@Component({
  selector: 'app-tournament-winner',
  templateUrl: './tournament-winner.component.html',
  styleUrls: ['./tournament-winner.component.css']
})
export class TournamentWinnerComponent implements OnInit {
  tournamentWinners: Observable<TournamentWinner[]>;
  constructor(private tournamentWinnerService: TournamentWinnerService) { }

  ngOnInit() {
    this.tournamentWinners = this.tournamentWinnerService.getTournamentWinners();
  }
}
