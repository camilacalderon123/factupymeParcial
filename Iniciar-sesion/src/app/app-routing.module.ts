import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';



import { InicioComponent } from '../../../FrontendCliente/src/app/inicio/inicio.component';
import { CrearCuentaComponent } from './crear-cuenta/crear-cuenta.component';
import { IniciarSesionComponent } from './iniciar-sesion/iniciar-sesion.component';


const routes: Routes = [

  {path: '', redirectTo:'/iniciar-sesion',pathMatch:'full' },
  {path: 'crear-cuenta', component:CrearCuentaComponent },
  {path: 'iniciar-sesion', component:IniciarSesionComponent },
  {path: 'inicio', component:InicioComponent}
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