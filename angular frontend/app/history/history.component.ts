import { Component, OnInit } from '@angular/core';
import { Bank, BankService,History } from '../bank.service';

@Component({
    selector: 'app-history',
    templateUrl: './history.component.html',
    styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

    acc_id: number;

    amount: number;

    display:boolean = false;

 trans: History[];

  



    constructor(private bankSer: BankService) { }

    ngOnInit() {
    }

    history() {
        this.bankSer.history(this.acc_id)
            .subscribe(response => {
                this.trans = response;
            });

        this.display=true;

    }
}

 
