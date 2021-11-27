import { Component, OnInit } from '@angular/core';
import { Producto } from '../models/Producto';
import { ProductoServiceService } from '../service/producto-service.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-agregar-producto',
  templateUrl: './agregar-producto.component.html',
  styleUrls: ['./agregar-producto.component.css']
})
export class AgregarProductoComponent implements OnInit {

  producto:Producto = new Producto();
  
  //Con productoService nos vamos a conectar al API rest 
  //Con route podemos navegar nuevamente a la lista de productos una vez que se haya guardado
  constructor(private productoService:ProductoServiceService, private router:Router, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  }

  //metodo donde implementamos la logica para guardar el producto
  create():void{
    console.log(this.producto);
    this.productoService.create(this.producto).subscribe(
      res => this.router.navigate(['/ver-productos'])
    ); 
  }
}
