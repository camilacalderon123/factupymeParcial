import { Component, OnInit } from '@angular/core';
import { Producto } from './producto';
import { ProductoServiceService } from './producto-service.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {

  titulo:string="Lista de productos";
  prueba:string="Esto es una prueba de mi componente producto";
  productos:Producto[];

  constructor(private productoService:ProductoServiceService) { }

  ngOnInit(): void {
    this.productoService.getAll().subscribe(
      p => this.productos=p
    );
  }

  delete(productos:Producto):void{
    console.log("si funciona el delete");
    this.productoService.delete(productos.codigo).subscribe(
      product => this.productoService.getAll().subscribe(
        response  => this.productos = response
      )
    );
  }

}
