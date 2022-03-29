import { Injectable } from '@angular/core';
import { Producto } from './lista-productos/Producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoDataService {

  constructor() { }

  productos: Producto[] = [
    {
      tipo: "Aceite de motor",
      nombre: "Elaion F30",
      precio: 1450,
      stock: 10,
      cantidad: 0,
      oferta: false,
    },
    {
      tipo: "Refrigerante",
      nombre: "TIR",
      precio: 800,
      stock: 3,
      cantidad: 0,
      oferta: false,
    },
    {
      tipo: "Refrigerante",
      nombre: "Quartz red",
      precio: 450,
      stock: 0,
      cantidad: 0,
      oferta: false,
    },
    {
      tipo: "Aceite de motor",
      nombre: "Helix hx8",
      precio: 3450,
      stock: 4,
      cantidad: 0,
      oferta: false,
    },
    {
      tipo: "Luz halogena",
      nombre: "general electric h7",
      precio: 100,
      stock: 50,
      cantidad: 0,
      oferta: true,
    },
    {
      tipo: "Aceite de motor",
      nombre: "Helix hx4",
      precio: 1440,
      stock: 0,
      cantidad: 0,
      oferta: false,
    },
    {
      tipo: "Filtro de combustible",
      nombre: "wega wo 130",
      precio: 500,
      stock: 8,
      cantidad: 0,
      oferta: true,
    },
    {
      tipo: "Filtro de aire",
      nombre: "wega fcd 226/2",
      precio: 380,
      stock: 0,
      cantidad: 0,
      oferta: false,
    },
  ]

  getProductos(){
    return this.productos;
  }
  
}
