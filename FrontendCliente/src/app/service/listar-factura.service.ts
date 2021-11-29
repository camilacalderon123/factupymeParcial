import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Factura } from '../models/Factura';

@Injectable({
  providedIn: 'root'
})
export class ListarFacturaService {
  private url:string="http://localhost:8090/api/facturacion-f/factura/"

  constructor(private http:HttpClient) { }

    //Obtener facturas
    getAll():Observable<Factura[]>{
      return this.http.get<Factura[]>(this.url);
    }
}
