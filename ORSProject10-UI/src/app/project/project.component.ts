import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent extends BaseCtl {

constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.PROJECT, locator, route);
  }
  validate() {
    return this.validateForm(this.form.data);
  }
  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    console.log("in valiadte form");
    flag = flag && validator.isNotNullObject(form.name);
    flag = flag && validator.isNotNullObject(form.description);
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.name = data.name;
    form.description = data.description;
   
  }

}