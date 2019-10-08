export class User {
    user_id: number;
    name: string;
    token: string;

    constructor(name: string, token: string, id: number){
        this.name = name;
        this.token = token;
        this.user_id = id;
    }
}