import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import {SummaryComponent} from './summary/summary.component';
import {UploadFileComponent} from './upload-file/upload-file.component';

const routes: Routes = [
  { path: '', component: EmployeeComponent, canActivate: [AuthGaurdService] },
  { path: 'addemployee', component: AddEmployeeComponent, canActivate: [AuthGaurdService]},
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent, canActivate: [AuthGaurdService] },
  { path: 'summary', component: SummaryComponent, canActivate: [AuthGaurdService]},
  { path: 'uploadfile', component: UploadFileComponent, canActivate: [AuthGaurdService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
