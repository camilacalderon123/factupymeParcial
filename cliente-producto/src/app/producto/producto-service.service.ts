import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Producto } from './producto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoServiceService {

  //url a la que nos vamos a conectar  a nuestra api rest
  private url:string="http://localhost:8090/api/facturacion/producto/";

  constructor(private http:HttpClient) { }

  //Funciones para poder hacer el llamado a nuestra api rest

  //Obtener productos
  getAll():Observable<Producto[]>{
    return this.http.get<Producto[]>(this.url);
  }

  //Crear producto
  create(producto:Producto):Observable<Producto>{
    return this.http.post<Producto>(this.url, producto);
  }

  //Obtener un producto
  get(codigo:number):Observable<Producto>{
    return this.http.get<Producto>(this.url+'listar-codigo/'+codigo);
  }

  //Actualizar un producto
  update(producto:Producto):Observable<Producto>{
    return this.http.put<Producto>(this.url, producto);
  }

  //Eliminar un producto
  delete(codigo:number):Observable<Producto>{
    return this.http.delete<Producto>(this.url+'/'+codigo);
  }

}
