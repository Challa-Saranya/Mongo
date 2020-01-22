import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAccountComponent } from './add-account/add-account.component';
import { ShowBalanceComponent } from './show-balance/show-balance.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { FundtransferComponent } from './fundtransfer/fundtransfer.component';
import { HistoryComponent } from './history/history.component';

const routes: Routes = [{
  path:'CreateAccount',
  component:AddAccountComponent
},
{
 path:'ShowBalance', 
 component:ShowBalanceComponent  
},
{
    path:'Deposit',
    component:DepositComponent
},
{
    path:'WithDraw',
    component:WithdrawComponent
},
{
    path:'FundTransfer',
    component:FundtransferComponent
},
{
    path:'History',
    component:HistoryComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
