import { Component, NgModule } from '@angular/core';
import { FormGroup,FormBuilder, Validators, FormControl } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth/auth.service';
import{NzMessageService} from 'ng-zorro-antd/message'
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss'] // Note: Use 'styleUrls' instead of 'styleUrl'

})




export class SignupComponent {

  isSpinning: boolean=false;
  signupForm!: FormGroup;

  constructor(private fb:FormBuilder,
    private authService:AuthService,
    private message:NzMessageService,
    private router:Router
  ){ }

  ngOnInit(){
    this.signupForm=this.fb.group({
      name:['',[Validators.required]],
      email:['',[Validators.required,Validators.email]],
      password:['',[Validators.required]],
      checkPassword:['',[Validators.required,this.cofirmationValidate]],

    })
  }

  cofirmationValidate=(control:FormControl):{[s:string]:boolean} =>{
    if(!control.value){
      return{required:true};
    }else if(control.value!==this.signupForm.controls['password'].value){
      return{confirm:true,error:true};
    }return{};
  };

  register(){
    console.log(this.signupForm.value);
    this.authService.register(this.signupForm.value).subscribe((res)=>{
      console.log(res);
      if(res.id!=null){
        this.message.success("signup Successful",{nzDuration:5000});
        this.router.navigateByUrl("/login")
      }else{
        this.message.error('something went wrong',{nzDuration:5000});
      }
    })
  }
}
