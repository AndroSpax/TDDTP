import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-better-form',
  templateUrl: './better-form.component.html',
  styleUrls: ['./better-form.component.css']
})

export class BetterFormComponent implements OnInit {
  myForm: FormGroup;
  userName: AbstractControl;
  constructor(fb: FormBuilder) {
    this.myForm = fb.group({
      'userName': ['', Validators.required]
    })
    this.userName = this.myForm.controls['userName'];
  }
  onSubmit(value: string): void {
    console.log('yu submitted value: ', value);
  }

  ngOnInit(): void {
  }
}
