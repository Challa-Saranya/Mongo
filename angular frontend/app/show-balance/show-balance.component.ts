import { Component, OnInit } from '@angular/core';
import { Bank, BankService } from '../bank.service';

@Component({
  selector: 'app-show-balance',
  templateUrl: './show-balance.component.html',
  styleUrls: ['./show-balance.component.css']
})
export class ShowBalanceComponent implements OnInit {


    acc_id: number;
    
    amount:number;

    result:string;

  constructor(private bankSer: BankService) { }

  ngOnInit() {
  }

   showBalance() {
    this.bankSer.showBalance(this.acc_id)
    .subscribe(response =>{
      this.result = response;
    });

   
  }
}
