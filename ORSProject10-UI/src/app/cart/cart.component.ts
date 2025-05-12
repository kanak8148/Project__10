import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent extends BaseCtl {

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
     super(locator.endpoints.CART, locator, route);
   }
   validate() {
     return this.validateForm(this.form.data);
   }
   validateForm(form) {
     let flag = true;
     let validator = this.serviceLocator.dataValidator;
     flag = flag && validator.isNotNullObject(form.customerName);
     flag = flag && validator.isNotNullObject(form.product);
     flag = flag && validator.isNotNullObject(form.date);
     flag = flag && validator.isNotNullObject(form.quantityOrdered);
     return flag;
   }
 
   populateForm(form, data) {
     form.id = data.id;
     form.customerName = data.customerName;
     form.product = data.product;
     form.date = data.date;
     form.quantityOrdered = data.quantityOrdered;
    
   }
   parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }
  test() {

  }
 
 }