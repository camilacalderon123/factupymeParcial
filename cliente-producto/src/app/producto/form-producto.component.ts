import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from './producto';
import { ProductoServiceService } from './producto-service.service';

@Component({
  selector: 'app-form-producto',
  templateUrl: './form-producto.component.html',
  styleUrls: ['./form-producto.component.css']
})
export class FormProductoComponent implements OnInit {

  //Declaramos el objeto para mapearlo con la vista 
  //Los parametros que vienen de la vista se guardan en un objeto tipo producto para luego guardarlo en la BD
  producto:Producto = new Producto();
  titulo:string="Registro de producto";

  constructor(private productoService:ProductoServiceService, private router:Router) { }

  ngOnInit(): void {
  }

  //creamos el método donde vamos a implementar la lógica para hacer el gaurdado
  //Cuando presione el botón en el formulario va a venir a este método 
  create():void{
    //cuando presione el botón va a imprimir los atributos de producto que le haya enviado por el formulario
    console.log(this.producto);
  }
}
