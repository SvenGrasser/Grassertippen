export class Tournament {
  constructor(
    public id: number,
    public descriptionShort: string,
    public description: string,
  ) { }

  number;

    get Number() {
        return this.number;
    }

    set Number(val) {
        this.number = val;
    }
}