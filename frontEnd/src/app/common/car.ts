export class Car {
    model: string;
    baseprice: number;
    year: number;
    car_id: number;
    picture: string;
    make: string;
    USD: number;
    EUR: number;
    JPY: number;
    BGN: number;
    CZK: number;
    DKK: number;
    GBP: number;
    HUF: number;
    PLN: number;
    RON: number;
    SEK: number;
    CHF: number;
    ISK: number;
    NOK: number;
    HRK: number;
    RUB: number;
    TRY: number;
    AUD: number;
    BRL: number;
    CAD: number;
    CNY: number;
    HKD: number;
    IDR: number;
    ILS: number;
    INR: number;
    KRW: number;
    MXN: number;
    MYR: number;
    NZD: number;
    PHP: number;
    SGD: number;
    THB: number;
    ZAR: number;
    latitude: number;
    longitude: number;
    selected_style: string = "";
    private toggle: boolean = false;
    
    public deselect(){
        this.selected_style = "";
    }

    public get_selected_style(): string{
        return this.selected_style;
    }

    public toggle_selection() {
        this.toggle = !this.toggle;
        
    }

    public get_toggle(): boolean{
        return this.toggle;
    }
}