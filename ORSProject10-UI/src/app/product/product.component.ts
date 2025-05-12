import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent extends BaseCtl {

 constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
     super(locator.endpoints.PRODUCT, locator, route);
   }
   validate() {
     return this.validateForm(this.form.data);
   }
   validateForm(form) {
     let flag = true;
     let validator = this.serviceLocator.dataValidator;
     console.log("in valiadte form");
     flag = flag && validator.isNotNullObject(form.totalQuantity);
     flag = flag && validator.isNotNullObject(form.product);
     flag = flag && validator.isNotNullObject(form.date);
     flag = flag && validator.isNotNullObject(form.totalCost);
     return flag;
   }
 
   populateForm(form, data) {
     form.id = data.id;
     form.name = data.name;
     form.totalQuantity = data.totalQuantity;
     form.product = data.product;
     form.date = data.date;
     form.totalCost = data.totalCost;
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
