import { Observable } from "rxjs";
import { MemberDetails } from "./memberDetails";

export class MemberSummary {
  constructor(
    public id: number,
    public isActive: boolean,
    public name: string,
    public score: number,
    public gold: number,
    public silver: number,
    public bronze: number
  ) {
    this.isDetailsVisible = false;
   }

  memberDetails: Observable<MemberDetails[]>;
  isDetailsVisible: boolean;

  get MemberDetails() {
    return this.memberDetails;
  }
  set MemberDetails(theMemberDetails) {
    this.memberDetails = theMemberDetails;
  }

  get IsDetailsVisible() {
    return this.isDetailsVisible;
  }
  set IsDetailsVisible(theDetailsVisible) {
    this.isDetailsVisible = theDetailsVisible;
  }
}