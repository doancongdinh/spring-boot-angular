import {Component, OnInit} from '@angular/core';
import {SummaryService} from '../../shared/services/summary.service';
import {AngularFireFunctions} from '@angular/fire/functions';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {
  summary: any;
  data: any;
  constructor(private summaryService: SummaryService, private afFun: AngularFireFunctions) {
  }

  ngOnInit(): void {
    this.summaryService.getSummary().subscribe(item => {
      this.summary = item;
    });
    this.summaryService.getGlobal().subscribe(item => {
      this.data = item;
    });
  }

  onChange(item: any) {
    this.summaryService.getByCountry(item).subscribe(res => {
      this.data = res;
    });

    // this.afFun.httpsCallable('getDataByCountry')({data: item})
    //   .pipe(first())
    //   .subscribe((resp: any) => {
    //     this.data = resp;
    //   }, err => {
    //     console.error({err});
    //   });
  }

}
