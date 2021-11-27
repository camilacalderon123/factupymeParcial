import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from '../models/Cliente';
import { ClienteService } from '../service/cliente.service';


@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent implements OnInit {
  clientes:Cliente = new Cliente();
  
  constructor(private clienteService:ClienteService,private router:Router, private activatedRoute:ActivatedRoute) { }
  

  ngOnInit(): void {
    this.traerCliente();
  }
  traerCliente():void{
    this.activatedRoute.params.subscribe(
      c =>{
        let id = c['id'];
        if(id){
          this.clienteService.get(id).subscribe(
            client => this.clientes=client
          );
        }
      }
    );
  }
  
  
}
