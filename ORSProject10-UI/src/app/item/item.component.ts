import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent extends BaseCtl {


   constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
       super(locator.endpoints.ITEM, locator, route);
     }
     validate() {
       return this.validateForm(this.form.data);
     }
     validateForm(form) {
       let flag = true;
       let validator = this.serviceLocator.dataValidator;
       flag = flag && validator.isNotNullObject(form.overview);
       flag = flag && validator.isNotNullObject(form.title);
       flag = flag && validator.isNotNullObject(form.purchaseDate);
       flag = flag && validator.isNotNullObject(form.category);
       return flag;
     }
   
     populateForm(form, data) {
       form.id = data.id;
       form.overview = data.overview;
       form.title = data.title;
       form.purchaseDate = data.purchaseDate;
       form.category = data.category;
      
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