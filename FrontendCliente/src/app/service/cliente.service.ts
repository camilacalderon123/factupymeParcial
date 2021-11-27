import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../models/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private url:string="http://localhost:8090/api/facturacion-c/cliente/"; //url para conectarnos con la API
  
  //http:HttpClient objeto que nos permite hacer las llamadas hacia nuestra API rest
  constructor(private http:HttpClient) { }

  //listando los clientes
  getAll():Observable<Cliente[]>{
    return this.http.get<Cliente[]>(this.url);
  }

  //listando por ID
  get(id_cliente:number):Observable<Cliente>{
    return this.http.get<Cliente>(this.url + 'listar-id/' + id_cliente);
  }

  //crear cliente -- recibimos el objeto cliente
  create(cliente:Cliente):Observable<Cliente>{
    return this.http.post<Cliente>(this.url ,cliente);
  }

  //Actualizar
  update(cliente:Cliente):Observable<Cliente>{
    return this.http.put<Cliente>(this.url,cliente);
  }

  //Elimianr
  delete(id_cliente:number):Observable<Cliente>{
    return this.http.delete<Cliente>(this.url +'eliminar/' + id_cliente);
  }

}
