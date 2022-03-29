import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShopComponent } from './shop/shop.component';
import { CatalogoComponent } from './catalogo/catalogo.component';
import { AboutComponent } from './about/about.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { ListaProductosComponent } from './lista-productos/lista-productos.component';
import { FormsModule } from '@angular/forms';
import { InputCompraComponent } from './input-compra/input-compra.component';
import { CarritoComponent } from './carrito/carrito.component'

@NgModule({
  declarations: [
    AppComponent,
    ShopComponent,
    CatalogoComponent,
    AboutComponent,
    NavComponent,
    FooterComponent,
    ListaProductosComponent,
    InputCompraComponent,
    CarritoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
