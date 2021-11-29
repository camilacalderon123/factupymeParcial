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





const routes:Routes=[
    {path: '', redirectTo:'/inicio',pathMatch:'full' },
    {path: 'ver-clientes', component:ClientesComponent },
    {path: 'clientes/form', component:AgregarClienteComponent },
    {path: 'clientes/editar/:id', component:EditarClienteComponent },

    {path: 'ver-productos', component:ProductoComponent },
    {path: 'productos/form', component:AgregarProductoComponent },
    {path: 'productos/editar/:codigo', component:EditarProductoComponent },

    {path: 'ver-rangos', component: RangoNumeracionComponent},
    {path: 'rangos/form', component: AgregarRangoComponent},

    {path: 'inicio', component: InicioComponent},
    {path: 'inicio/empresa', component: EmpresaComponent},

    {path: 'ver-facuras', component: ListarFacturasComponent},
    {path: 'emitirFactura', component:ModalComponent},
    {path: 'emitirFactura/datos/:id', component:FacturaComponent },
    {path: 'emitirFactura/total', component:VerTotalComponent},
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
