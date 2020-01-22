import { Component, OnInit } from '@angular/core';
import { Bank, BankService } from '../bank.service';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {

   acc_id: number;
    
    amount:number;

    result: string;

  constructor(private bankSer: BankService) { }

  ngOnInit() {
  }



  deposit() {
    this.bankSer.deposit(this.acc_id,this.amount)
    .subscribe(response =>{
      this.result = response;
    });

   
  }

}
