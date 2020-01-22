import { Component } from '@angular/core';



@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {



}



export class Bank {
    account_id: number;
    customer_name: string;
    amount: number;
    contact_number: string;

  

    constructor(customer_name: string, amount: number, contact_number: string) {
        this.customer_name = customer_name;
        this.amount = amount;
        this.contact_number = contact_number;
    }
}
