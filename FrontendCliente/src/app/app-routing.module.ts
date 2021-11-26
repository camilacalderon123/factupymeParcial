import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ClientesComponent } from './clientes/clientes.component';
import { AgregarClienteComponent } from './clientes/agregar-cliente.component';
import { EditarClienteComponent } from './clientes/editar-cliente.component';



const routes:Routes=[
    {path: '', redirectTo:'/ver-clientes',pathMatch:'full' },
    {path: 'ver-clientes', component:ClientesComponent },
    {path: 'clientes/form', component:AgregarClienteComponent },
    {path: 'clientes/editar/:id', component:EditarClienteComponent },
    {path: '**', redirectTo:'/', pathMatch:'full' } //aca tengo que redireccionarlo al 404
]


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes, {useHash: true})
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { 
  


}
