import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './auth/components/signup/signup.component';
import { LoginComponent } from './auth/components/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
const routes: Routes = [
  {path:"register",component:SignupComponent},
  {path:"login",component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    ReactiveFormsModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
