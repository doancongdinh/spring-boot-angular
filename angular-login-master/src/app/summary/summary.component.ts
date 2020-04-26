import {Component, OnDestroy, OnInit} from '@angular/core';
import {HttpClientService} from '../service/httpclient.service';
import {interval, Subscription} from 'rxjs';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit, OnDestroy {
  subscribe: Subscription;
  summary: any;
  constructor(private httpClientService: HttpClientService) { }

  ngOnInit() {
    this.getData();
  }

  getData() {
    const source = interval(10000);
    this.subscribe = source.subscribe(() => this.httpClientService.getSummary().subscribe(res => {
      this.summary = res;
      console.log(this.summary.global);
    }));
  }

  ngOnDestroy(): void {
    if (!this.subscribe) {
      this.subscribe.unsubscribe();
    }
  }

}
