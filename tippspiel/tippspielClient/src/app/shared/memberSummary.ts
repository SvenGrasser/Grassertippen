export class MemberSummary {
    constructor(
      public id: number,
      public isActive: boolean,
      public name: string,
      public score: number,
      public gold: number,
      public silver: number,
      public bronze: number
    ) { }  
  }