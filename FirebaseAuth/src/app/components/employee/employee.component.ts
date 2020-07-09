import { Component, OnInit } from '@angular/core';
import {CrudService} from '../../shared/services/crud.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employee: any;
  employeeName: string;
  employeeAge: number;
  employeeAddress: string;
  message: string;
  constructor(public crudservice: CrudService) {}

  ngOnInit(): void {
    this.crudservice.get_Allemployee().subscribe(data => {

      this.employee = data.map( (e: any) => {
        return {
          id: e.payload.doc.id,
          isedit: false,
          name: e.payload.doc.data().name,
          age: e.payload.doc.data().age,
          address: e.payload.doc.data().address,
        };
      });
    });
  }

  CreateRecord() {
    const Record = {
      name: '',
      age: 0,
      address: ''
    };
    Record.name = this.employeeName;
    Record.age = this.employeeAge;
    Record.address = this.employeeAddress;

    this.crudservice.create_Newemployee(Record).then(res => {

      this.employeeName = '';
      this.employeeAge = undefined;
      this.employeeAddress = '';
      console.log(res);
      this.message = 'Employee data save Done';
    }).catch(error => {
      console.log(error);
    });

  }

  EditRecord(Record) {
    Record.isedit = true;
    Record.editname = Record.name;
    Record.editage = Record.age;
    Record.editaddress = Record.address;

  }

  Updatarecord(recorddata) {
    const record = {
      name: '',
      age: 0,
      address: ''
    };
    record.name = recorddata.editname;
    record.age = recorddata.editage;
    record.address = recorddata.editaddress;
    this.crudservice.update_employee(recorddata.id, record);
    recorddata.isedit = false;
  }

  Deleteemployee(record_id) {
    this.crudservice.delete_employee(record_id);
  }

}
