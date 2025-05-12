import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  save(){
    if(true){
        let x =1;
        var y = 2;
        console.log(x);

    }
    console.log(y);
}

}
