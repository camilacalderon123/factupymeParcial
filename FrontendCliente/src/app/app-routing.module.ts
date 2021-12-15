import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ClientesComponent } from './clientes/clientes.component';
import { AgregarClienteComponent } from './clientes/agregar-cliente.component';
import { EditarClienteComponent } from './clientes/editar-cliente.component';
import { FacturaComponent } from './factura/factura.component';
import { VerTotalComponent } from './factura/ver-total.component';
import { ModalComponent } from './factura/modal.component';
import { ProductoComponent } from './producto/producto.component';
import { AgregarProductoComponent } from './producto/agregar-producto.component';
import { EditarProductoComponent } from './producto/editar-producto.component';
import { RangoNumeracionComponent } from './rango-numeracion/rango-numeracion.component';
import { AgregarRangoComponent } from './rango-numeracion/agregar-rango.component';
import { InicioComponent } from './inicio/inicio.component';
import { EmpresaComponent } from './empresa/empresa.component';
import { ListarFacturasComponent } from './factura/listar-facturas.component';
import { IniciarSesionComponent } from './iniciar-sesion/iniciar-sesion.component';
import { CrearUsuarioComponent } from './crear-usuario/crear-usuario.component';
import { LayoutsComponent } from './layouts/layouts.component';





const routes:Routes=[
   {
    path: '', 
    redirectTo:'inicio',
    pathMatch:'full'
   },
   {path: 'login', 
   component: IniciarSesionComponent,
   data: {title: 'login'} 
   }, //LOGIN
   {path: 'create',
    component: CrearUsuarioComponent,
    data: {title: 'create'} 
   },//CREATE
   {
     path: '',
     component: LayoutsComponent,
     children: [
       {
        path: 'ver-clientes', 
        component:ClientesComponent,
        data: {title: 'ver-clientes'}
       },
       {
        path: 'clientes/form', 
        component:AgregarClienteComponent,
        data: {title: 'agregar-clientes'}        
       },
       {
        path: 'clientes/editar/:id', 
        component:EditarClienteComponent,
        data: {title: 'editar-clientes'}          
       },
       {
        path: 'ver-productos', 
        component:ProductoComponent ,
        data: {title: 'ver-productos'}         
       },
       {
        path: 'productos/form', 
        component:AgregarProductoComponent ,
        data: {title: 'agregar-productos'}         
       },
       {
        path: 'productos/editar/:codigo', 
        component:EditarProductoComponent ,
        data: {title: 'editar-productos'}         
       },    
       {
        path: 'ver-rangos', 
        component:RangoNumeracionComponent ,
        data: {title: 'ver-rangos'}         
       },    
       {
        path: 'rangos/form', 
        component:AgregarRangoComponent ,
        data: {title: 'agregar-rangos'}         
       }, 
       {
        path: 'inicio', 
        component:InicioComponent ,
        data: {title: 'inicio'}         
       },  
       {
        path: 'inicio/empresa', 
        component:EmpresaComponent ,
        data: {title: 'inicio-empresa'}         
       }, 
       {
        path: 'ver-facuras', 
        component:ListarFacturasComponent ,
        data: {title: 'ver-facuras'}         
       },
       {
        path: 'emitirFactura', 
        component:ModalComponent ,
        data: {title: 'emitir-factura'}         
       },
       {
        path: 'emitirFactura/datos/:id', 
        component:FacturaComponent ,
        data: {title: 'emitir-factura-datos'}         
       },  
       {
        path: 'emitirFactura/total', 
        component:VerTotalComponent ,
        data: {title: 'emitir-factura-total'}         
       },
       {path: '**', 
       redirectTo:'/', 
       pathMatch:'full' } 
     ]
   }
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
