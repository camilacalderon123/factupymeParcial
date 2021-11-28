import { Component, OnInit } from '@angular/core';
import { RangoNumeracion } from './rango-numeracion';
import { RangoNumeracionService } from './rango-numeracion.service';

@Component({
  selector: 'app-rango-numeracion',
  templateUrl: './rango-numeracion.component.html',
  styleUrls: ['./rango-numeracion.component.css']
})
export class RangoNumeracionComponent implements OnInit {


  rangosNumeracion:RangoNumeracion[];

  constructor(private rangoNumeracionService:RangoNumeracionService) { }

  ngOnInit(): void {
    this.rangoNumeracionService.getAll().subscribe(
      r => this.rangosNumeracion=r
    );
  }

}
