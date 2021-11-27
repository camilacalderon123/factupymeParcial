import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from '../service/cliente.service';
import { Cliente } from '../models/Cliente';

@Component({
  selector: 'app-agregar-cliente',
  templateUrl: './agregar-cliente.component.html',
  styleUrls: ['./agregar-cliente.component.css']
})
export class AgregarClienteComponent implements OnInit {
  
  clientes:Cliente = new Cliente();
  
  constructor(private clienteService:ClienteService, private router:Router, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {

  }

  //metodo donde implementamos la logica para guardar el cliente
  create():void{
    console.log(this.clientes);
    this.clienteService.create(this.clientes).subscribe(
      res => this.router.navigate(['/ver-clientes'])
    ); 
  }



}
