export class TournamentWinner {
    constructor(
      public tournament: string,
      public winner: string,
      public result: number,
      public matchDayVictory: number,
      public averageAllTipprs: number,
    ) { }
  }