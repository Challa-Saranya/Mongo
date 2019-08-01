import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Passwordmatch } from './Passwordvalidation';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  title = 'SignUp';
 
  myForm: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) { }
  _formValidate() {
    // Here we have used a form builder and an array to allow for multiple validation rules on a form.
    this.myForm = this.fb.group(
      {
        firstname: ['', Validators.compose([Validators.required,Validators.minLength(4),Validators.pattern("[a-zA-Z ]*")])],
        lastname: ['', Validators.compose([Validators.required,Validators.minLength(4)])],
        phnum:['', Validators.compose([Validators.required,Validators.minLength(10)])],
        email: ['', Validators.compose([Validators.required, Validators.email])],
        pwd: ['', Validators.compose([Validators.required, Validators.minLength(6)])],
        cnfPwd: ['', Validators.required]
      },
      {
        validator: Passwordmatch.matchPassword
      }
    );
  }
  get f() { return this.myForm.controls; }

  ngOnInit() {
    this._formValidate();
  }
  

  // To show how developers can access the form control values.
  _formSubmit() {
    if (this.myForm.invalid) {
      return;
    }
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.myForm.getRawValue()));
  }
  

}
