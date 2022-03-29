import { Component, OnInit } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { Producto } from '../lista-productos/Producto';
import { ProductosCartService } from '../productos-cart.service';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})

export class CarritoComponent implements OnInit {

  listaCompras$: Observable<Producto[]>;
  
  constructor(private carrito: ProductosCartService) { 
    this.listaCompras$ = carrito.listaCompras.asObservable();
  }

  ngOnInit(): void {
  }

}
