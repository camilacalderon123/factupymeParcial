import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../service/cliente.service';
import { Cliente } from '../models/Cliente';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[];

  constructor(private clienteService:ClienteService) { 

  }

  ngOnInit(): void {
    this.clienteService.getAll().subscribe(
      client=>this.clientes = client
    );
  }

  delete(clientes:Cliente):void{
    this.clienteService.delete(clientes.numero_documento).subscribe(
      client => this.clienteService.getAll().subscribe(
        response  => this.clientes = response
      )
    );
  }

}
