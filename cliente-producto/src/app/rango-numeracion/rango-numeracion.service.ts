import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RangoNumeracion } from './rango-numeracion';

@Injectable({
  providedIn: 'root'
})
export class RangoNumeracionService {

  private url:string="http://localhost:8090/api/facturacion/rango_numeracion/"

  constructor(private http:HttpClient) { }

  //Obtener rangos
  getAll():Observable<RangoNumeracion[]>{
    return this.http.get<RangoNumeracion[]>(this.url);
  }

  //Crear rangos
  create(rangoNumeracion:RangoNumeracion):Observable<RangoNumeracion>{
    return this.http.post<RangoNumeracion>(this.url, rangoNumeracion);
  }

  //Obtener un rango
  get(id_numeracion:number):Observable<RangoNumeracion[]>{
    return this.http.get<RangoNumeracion[]>(this.url+'listar-rangos/'+id_numeracion);
  }

  //Actualizar un rango
  update(rangoNumeracion:RangoNumeracion):Observable<RangoNumeracion>{
    return this.http.put<RangoNumeracion>(this.url, rangoNumeracion);
  }

  //Eliminar un rango
  delete(id_numeracion:number):Observable<RangoNumeracion[]>{
    return this.http.delete<RangoNumeracion[]>(this.url+'/'+id_numeracion);
  }
}
