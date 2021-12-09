import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Empresa } from '../models/Empresa';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  //url a la que nos vamos a conectar  a nuestra api rest
  private url:string="http://localhost:8090/api/facturacion/Empresa/";

  constructor(private http:HttpClient) { }

  //Funciones para poder hacer el llamado a nuestra api rest

  //Obtener Empresa
  getAll():Observable<Empresa[]>{
    return this.http.get<Empresa[]>(this.url);
  }

  //Crear Empresa
  create(empresa:Empresa):Observable<Empresa>{
    return this.http.post<Empresa>(this.url, empresa);
  }

  //Obtener un Empresa
  get(nit:number):Observable<Empresa>{
    return this.http.get<Empresa>(this.url+'listar-nit/'+nit);
  }

  //Actualizar un producto
  update(empresa:Empresa):Observable<Empresa>{
    return this.http.put<Empresa>(this.url, empresa);
  }

}
