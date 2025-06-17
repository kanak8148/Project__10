import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { BaseListCtl } from '../base-list.component';

@Component({
  selector: 'app-faculty-list',
  templateUrl: './faculty-list.component.html',
  styleUrls: ['./faculty.component.css']
})
export class FacultyListComponent  extends BaseListCtl {

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
    super( locator.endpoints.FACULTY, locator, route);
  }

}