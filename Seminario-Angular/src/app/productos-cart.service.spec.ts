import { TestBed } from '@angular/core/testing';

import { ProductosCartService } from './productos-cart.service';

describe('ProductosCartService', () => {
  let service: ProductosCartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductosCartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
