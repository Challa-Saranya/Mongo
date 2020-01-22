import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';



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

export class History {
    trans_id: number;
    operation: string;
    acc_id: number;
    amount: number;

    constructor(trans_id: number, operation: string, acc_id: number, amount: number) {
        this.trans_id = trans_id;
        this.operation = operation;
        this.acc_id = acc_id;
        this.amount = amount;

    }

} 


@Injectable({
  providedIn: 'root'
})


export class BankService {

  constructor(private http:HttpClient) { }

  public createAccount(bank){
      const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.http.post("http://localhost:8085/wallet/create",bank,  { headers, responseType: 'text'});
  }

  public showBalance(acc_id){
      const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
      return this.http.get("http://localhost:8085/wallet/showBalance"+"/"+acc_id,  { headers, responseType: 'text'});

  }

   public deposit(acc_id,amount){
        const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
      return this.http.get("http://localhost:8085/wallet/deposit"+"/"+acc_id+"/"+amount,  { headers, responseType: 'text'});
  }

   public withdraw(acc_id,amount){
        const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
      return this.http.get("http://localhost:8085/wallet/withdraw"+"/"+acc_id+"/"+amount,  { headers, responseType: 'text'});
  }

   public fundtransfer(acc_id,acc_id2,amount){
        const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
      return this.http.get("http://localhost:8085/wallet/fundtransfer"+"/"+acc_id+"/"+acc_id2+"/"+amount,  { headers, responseType: 'text'});
  }
  
  
  public history(acc_id){
       const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
      return this.http.get<History[]>("http://localhost:8085/wallet/transactions/"+8);


  }

}
