import { Component, OnInit } from '@angular/core';
import { Producto } from '../models/Producto';
import { ProductoServiceService } from '../service/producto-service.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-editar-producto',
  templateUrl: './editar-producto.component.html',
  styleUrls: ['./editar-producto.component.css']
})
export class EditarProductoComponent implements OnInit {

  producto:Producto = new Producto();
  
  //Con productoService nos vamos a conectar al API rest 
  //Con route podemos navegar nuevamente a la lista de productos una vez que se haya guardado
  constructor(private productoService:ProductoServiceService, private router:Router, private activatedRoute:ActivatedRoute) { }

  //metodo que se carga cuando se accede al componente
  ngOnInit(): void {
    this.editProduct();
  }
  editProduct():void{
    //Nos subscribimos para obtener el registro
    this.activatedRoute.params.subscribe(
      p =>{
        //le digo que me almacene en una variable lo que me trae desde el enlace
        let codigo = p['codigo'];
        if(codigo){
          this.productoService.get(codigo).subscribe(
            product => this.producto=product
          );
        }
      }
    );

  }

  update():void{
    console.log(this.producto);
    this.productoService.update(this.producto).subscribe(
      res => this.router.navigate(['/ver-productos'])
    ); 
  }
}
