import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputCompraComponent } from './input-compra.component';

describe('InputCompraComponent', () => {
  let component: InputCompraComponent;
  let fixture: ComponentFixture<InputCompraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InputCompraComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InputCompraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
