import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { DataTablesModule } from 'angular-datatables';


//Imports de los componentes
import { AppComponent } from './app.component';
import { ClientesComponent } from './clientes/clientes.component';
import { BarraLateralComponent } from './shared/barra-lateral/barra-lateral.component';
import { HeaderComponent } from './shared/header/header.component';
import { AgregarClienteComponent } from './clientes/agregar-cliente.component';
import { AppRoutingModule } from './app-routing.module';
import { EditarClienteComponent } from './clientes/editar-cliente.component';
import { FacturaComponent } from './factura/factura.component';
import { VerTotalComponent } from './factura/ver-total.component';
import { ModalComponent } from './factura/modal.component';
import { ProductoComponent } from './producto/producto.component';
import { AgregarProductoComponent } from './producto/agregar-producto.component';
import { EditarProductoComponent } from './producto/editar-producto.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientesComponent,
    BarraLateralComponent,
    HeaderComponent,
    AgregarClienteComponent,
    EditarClienteComponent,
    FacturaComponent,
    VerTotalComponent,
    ModalComponent,
    ProductoComponent,
    AgregarProductoComponent,
    EditarProductoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    DataTablesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
