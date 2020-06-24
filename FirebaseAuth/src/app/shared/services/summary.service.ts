import { Injectable } from '@angular/core';
import {AngularFirestore} from '@angular/fire/firestore';

@Injectable({
  providedIn: 'root'
})
export class SummaryService {

  constructor(public fireservices: AngularFirestore) { }

  getSummary() {
    return this.fireservices.collection('Summary').snapshotChanges();
  }

  getGlobal() {
    return this.fireservices.collection('Summary').doc('global');
  }
}
