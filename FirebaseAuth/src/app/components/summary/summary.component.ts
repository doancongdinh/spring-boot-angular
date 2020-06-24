import { Component, OnInit } from '@angular/core';
import {SummaryService} from '../../shared/services/summary.service';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {

  constructor(private summary: SummaryService) { }

  ngOnInit(): void {
    this.summary.getSummary().subscribe(item => {
      item.forEach(e => console.log(e.payload.doc.data()));
    });
    this.summary.getGlobal().valueChanges().subscribe(item => {
      console.log(item);
    });
  }

}
