import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RangoNumeracion } from '../models/rango-numeracion';
import { RangoNumeracionService } from '../service/rango-numeracion.service';

@Component({
  selector: 'app-agregar-rango',
  templateUrl: './agregar-rango.component.html',
  styleUrls: ['./agregar-rango.component.css']
})
export class AgregarRangoComponent implements OnInit {

  rangoNumeracion:RangoNumeracion = new RangoNumeracion();
  constructor(private rangoNumeracionService:RangoNumeracionService, private router:Router) { }

  ngOnInit(): void {
  }

  createR():void {
    console.log(this.rangoNumeracion);
    this.rangoNumeracionService.create(this.rangoNumeracion).subscribe(
      res => this.router.navigate(['/ver-rangos'])
    );
  }

}
