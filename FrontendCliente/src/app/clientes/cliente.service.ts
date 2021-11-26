import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Clientes } from './clientes';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private url:string="http://localhost:8090/api/facturacion/cliente/"; //url para conectarnos con la API
  
  //http:HttpClient objeto que nos permite hacer las llamadas hacia nuestra API rest
  constructor(private http:HttpClient) { }

  //listando los clientes
  getAll():Observable<Clientes[]>{
    return this.http.get<Clientes[]>(this.url);
  }

  //listando por ID
  get(id_cliente:number):Observable<Clientes>{
    return this.http.get<Clientes>(this.url + 'listar-id/' + id_cliente);
  }

  //crear cliente -- recibimos el objeto cliente
  create(cliente:Clientes):Observable<Clientes>{
    return this.http.post<Clientes>(this.url ,cliente);
  }

  //Actualizar
  update(cliente:Clientes):Observable<Clientes>{
    return this.http.put<Clientes>(this.url,cliente);
  }

  //Elimianr
  delete(id_cliente:number):Observable<Clientes>{
    return this.http.delete<Clientes>(this.url +'eliminar/' + id_cliente);
  }

}
