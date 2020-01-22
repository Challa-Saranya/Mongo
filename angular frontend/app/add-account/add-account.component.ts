import { Component, OnInit } from '@angular/core';
import { Bank, BankService } from '../bank.service';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {

    user: Bank = new Bank("",0,"");
    result:string;

  constructor(private bankSer: BankService) { }

  ngOnInit() {
  }

  createAccount():void{
      this.bankSer.createAccount(this.user)
          .subscribe(data => {
              this.result=data});
      
  }
}
