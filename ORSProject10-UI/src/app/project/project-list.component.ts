import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent extends BaseListCtl {

 
     

     public form = {

      error: false, //error 
      message: null, //error or success message
      preload: [], // preload data
      data: { id: null}, //form data
      inputerror: {}, // form input error messages
      searchParams: {}, //search form
      searchMessage: null, //search result message
      list: [ ], // search list 
      pageNo: 0
    };
    constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
      super(locator.endpoints.PROJECT, locator, route);
    }
}
