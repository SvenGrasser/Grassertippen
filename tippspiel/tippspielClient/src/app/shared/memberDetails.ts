export class MemberDetails {
    constructor(
      public tournamentId: number,
      public tournamentDescriptionShort: string,
      public score: number,
      public position: number,
      public matchDayVictory: number,
    ) { }  
  }