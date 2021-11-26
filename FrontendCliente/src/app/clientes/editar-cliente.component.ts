import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from './cliente.service';
import { Clientes } from './clientes';

@Component({
  selector: 'app-editar-cliente',
  templateUrl: './editar-cliente.component.html',
  styleUrls: ['./editar-cliente.component.css']
})
export class EditarClienteComponent implements OnInit {
  clientes:Clientes = new Clientes();

  constructor(private clienteService:ClienteService, private router:Router, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.editClient();
  }
  editClient():void{
    this.activatedRoute.params.subscribe(
      c =>{
        let id = c['id'];
        if(id){
          this.clienteService.get(id).subscribe(
            client => this.clientes=client
          );
        }
      }
    );

  }

  update():void{
    this.clienteService.update(this.clientes).subscribe(
      res => this.router.navigate(['/ver-clientes'])
    ); 
  }
}
