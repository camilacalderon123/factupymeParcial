import { Component, OnInit } from '@angular/core';
import { Empresa } from '../models/Empresa';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpresaService } from '../service/empresa.service';


@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent implements OnInit {
  
  empresa:Empresa = new Empresa();
  
  constructor(private empresaService:EmpresaService, private router:Router, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {

  }

  //metodo donde implementamos la logica para guardar la empresa
  create():void{
    console.log(this.empresa);
    this.empresaService.create(this.empresa).subscribe(
      res => this.router.navigate(['/inicio'])
    ); 
  }



}