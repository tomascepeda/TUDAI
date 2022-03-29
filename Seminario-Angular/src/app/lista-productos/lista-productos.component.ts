import { Component, OnInit } from '@angular/core';
import { ProductoDataService } from '../producto-data.service';
import { ProductosCartService } from '../productos-cart.service';

@Component({
  selector: 'app-lista-productos',
  templateUrl: './lista-productos.component.html',
  styleUrls: ['./lista-productos.component.css']
})
export class ListaProductosComponent implements OnInit {

  productos = this.productosDataService.getProductos();

  constructor(
    private carrito: ProductosCartService,
    private productosDataService: ProductoDataService,
  ) { }

  ngOnInit(): void {
  }

  maxReached(max: boolean) {
    alert("Alcanzo el maximo de unidades para este producto");
  }

  agregarAlCarrito(producto) {
    if (producto.cantidad > 0) {
      this.carrito.agregarAlCarrito(producto);
      producto.stock -= producto.cantidad;
      producto.cantidad = 0;
    }
  }

}
