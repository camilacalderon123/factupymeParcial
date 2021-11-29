import { Component, OnInit } from '@angular/core';
import { Factura } from '../models/Factura';
import { Cliente } from '../models/Cliente';
import { ListarFacturaService } from '../service/listar-factura.service';

@Component({
  selector: 'app-listar-facturas',
  templateUrl: './listar-facturas.component.html',
  styleUrls: ['./listar-facturas.component.css']
})
export class ListarFacturasComponent implements OnInit {

  factura:Factura[];

  constructor(private listarFactura:ListarFacturaService) { }

  ngOnInit(): void {
    this.listarFactura.getAll().subscribe(
      f=>this.factura = f
    );
  }
 
}
