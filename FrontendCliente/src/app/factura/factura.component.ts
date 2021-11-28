import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from '../models/Cliente';
import { ClienteService } from '../service/cliente.service';
import { Producto } from '../models/Producto';
import { ProductoServiceService } from '../service/producto-service.service';


@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent implements OnInit {
  clientes:Cliente = new Cliente();
  productos: Producto[];
  
  constructor(private clienteService:ClienteService, private productoService:ProductoServiceService,private router:Router, private activatedRoute:ActivatedRoute) { }
  

  ngOnInit(): void {
    this.productoService.getAll().subscribe(
      product=>this.productos = product
    );

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
