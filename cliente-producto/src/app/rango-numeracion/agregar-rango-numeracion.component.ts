import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RangoNumeracion } from './rango-numeracion';
import { RangoNumeracionService } from './rango-numeracion.service';

@Component({
  selector: 'app-agregar-rango-numeracion',
  templateUrl: './agregar-rango-numeracion.component.html',
  styleUrls: ['./agregar-rango-numeracion.component.css']
})
export class AgregarRangoNumeracionComponent implements OnInit {

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
