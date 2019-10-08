export class RentCarRequest {

    currency: string;
    beginrental: Date;
    endrental: Date;
    user_id: number;
    car_id: number;

    constructor(currency: string, from: Date, to:Date, user_id:number, car_id:number){
        this.currency = currency;
        this.beginrental = from;
        this.endrental = to;
        this.user_id = user_id;
        this.car_id = car_id;
    }

}