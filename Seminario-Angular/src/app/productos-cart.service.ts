import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CarritoComponent } from './carrito/carrito.component';
import { Producto } from './lista-productos/Producto';

@Injectable({
  providedIn: 'root'
})
export class ProductosCartService {

  private _listaCompras: Producto[] = [];
  listaCompras: BehaviorSubject<Producto[]> = new BehaviorSubject(this._listaCompras);

  constructor() {}

  agregarAlCarrito(producto: Producto) {
    let item: Producto = this._listaCompras.find((v1) => v1.nombre == producto.nombre);
    if (!item) {
      this._listaCompras.push({ ...producto });
    } else {
      item.cantidad += producto.cantidad;
    }
    this.listaCompras.next(this._listaCompras);
  }

}
