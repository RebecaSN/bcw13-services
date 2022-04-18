import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listar-funcionario',
  templateUrl: './listar-funcionario.component.html',
  styleUrls: ['./listar-funcionario.component.css']
})
export class ListarFuncionarioComponent implements OnInit {

  funcionarios = [
    {
      id: 1,
      nome: 'Renato',
      email: 'renato@email.com',
      foto: 'asfasfasf'
    },
    {
      id: 1,
      nome: 'Denise',
      email: 'denise@email.com',
      foto: 'asfasfasf'
    },
    {
      id: 1,
      nome: 'Tatiana',
      email: 'tati@email.com',
      foto: 'asfasfasf'
    },
  ]

  columns: string[] = ['id', 'nome', 'email']

  constructor() { }

  ngOnInit(): void {
  }
}
