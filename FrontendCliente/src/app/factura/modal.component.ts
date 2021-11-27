import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../service/cliente.service';
import { Cliente } from '../models/Cliente';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  clientes: Cliente[];


  constructor(private clienteService:ClienteService) { }

  ngOnInit(): void {
    this.clienteService.getAll().subscribe(
      client=>this.clientes = client
    );
  }

  

}
