import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FuncionarioRoutingModule } from './funcionario-routing.module';
import { NovoFuncionarioComponent } from './pages/novo-funcionario/novo-funcionario.component';
import { MaterialModule } from '../material/material.module';
import { ListarFuncionarioComponent } from './pages/listar-funcionario/listar-funcionario.component';


@NgModule({
  declarations: [
    NovoFuncionarioComponent,
    ListarFuncionarioComponent
  ],
  imports: [
    CommonModule,
    FuncionarioRoutingModule,
    MaterialModule
  ]
})
export class FuncionarioModule { }
