import { Injectable } from '@angular/core';
import {AngularFirestore} from '@angular/fire/firestore';

@Injectable({
  providedIn: 'root'
})
export class SummaryService {

  constructor(public fireservices: AngularFirestore) { }

  getSummary() {
    return this.fireservices.collection('Summary').valueChanges();
  }

  getGlobal() {
    return this.fireservices.collection('Summary').doc('global').valueChanges();
  }

  getByCountry(country: string) {
    return this.fireservices.collection('Summary').doc(country).valueChanges();
  }

  getCountry() {
    return this.fireservices.collection('Summary',
        ref => ref.where('totalConfirmed', '>', 100000)
  ).valueChanges();
  }
}
