import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DawgFormComponent} from './dawg-form/dawg-form.component';
import {DawgListComponent} from './dawg-list/dawg-list.component';

export const routes: Routes = [
  {path: '' , component: DawgFormComponent},
  {path: 'dawgList', component: DawgListComponent},
  {path: '**', redirectTo: '/', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
