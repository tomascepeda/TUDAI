import { Component, OnInit } from '@angular/core';
import { ProductoDataService } from '../producto-data.service';

@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent implements OnInit {

  productos = this.productosDataService.getProductos();

  constructor(private productosDataService: ProductoDataService,) { }

  ngOnInit(): void {
  }

}
