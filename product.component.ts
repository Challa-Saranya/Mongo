import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  title='product';
  myForm:any=FormGroup;
  

  constructor(private fb: FormBuilder) { 
    this.myForm=this.fb.group({
      productname:new FormControl('', [Validators.required, Validators.compose([Validators.pattern('[a-zA-z ]*'), Validators.minLength(4)])]),
      productdescription:new FormControl('', [Validators.required, Validators.compose([Validators.pattern('[a-zA-z ]*'), Validators.minLength(4)])]),
      productprice:new FormControl('', [Validators.required, Validators.compose([Validators.pattern('[0-9 ]*')])]),
      productcategeory:new FormControl('', [Validators.required, Validators.compose([Validators.pattern('[a-zA-z ]*'), Validators.minLength(4)])])
    });
  }
  
  onSelectFile(event){
    const file=event.target.files[0];
    console.log(file);
  }
  
  

  ngOnInit() {
  }

}
