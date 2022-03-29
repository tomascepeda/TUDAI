import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-input-compra',
  templateUrl: './input-compra.component.html',
  styleUrls: ['./input-compra.component.css']
})
export class InputCompraComponent implements OnInit {

  constructor() { }

  @Input()
  cantidad: number;

  @Input()
  max: number;

  @Output()
  cantidadChange: EventEmitter<number> = new EventEmitter<number>();

  @Output()
  maxReached: EventEmitter<boolean> = new EventEmitter<boolean>(false);

  ngOnInit(): void {
  }

  restar() {
    if (this.cantidad > 0) {
      this.cantidad--;
      this.cantidadChange.emit(this.cantidad);
    }
  }

  aumentar() {
    if (this.cantidad < this.max) {
      this.cantidad++;
      this.cantidadChange.emit(this.cantidad);
    } else
      this.maxReached.emit(true);
  }

}
