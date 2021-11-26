import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
//Clase que nos permite trabjar con formularios
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { ProductoComponent } from './producto/producto.component';
import { BarraLateralComponent } from './shared/barra-lateral/barra-lateral.component';
import { HeaderComponent } from './shared/header/header.component';
import { VerProductosComponent } from './producto/ver-productos.component';
import { AgregarProductoComponent } from './producto/agregar-producto.component';
import { EditarProductoComponent } from './producto/editar-producto.component';
//Rutas
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    ProductoComponent,
    BarraLateralComponent,
    HeaderComponent,
    VerProductosComponent,
    AgregarProductoComponent,
    EditarProductoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    //RouterModule.forRoot(routes),
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
