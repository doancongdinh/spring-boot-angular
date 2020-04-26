import { Component, OnInit } from '@angular/core';
import {UploadFileService} from '../service/upload-file.service';
import {Observable} from 'rxjs';
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {FileInfo} from "./FileInfo";

@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.css']
})
export class UploadFileComponent implements OnInit {
  constructor(private uploadService: UploadFileService) { }

  selectedFiles: FileList;
  currentFile: File;
  progress = 0;
  message = '';

  fileInfos: Observable<any>;
  files: FileInfo[] = [];

  ngOnInit() {
    this.fileInfos = this.uploadService.getFiles();
  }
  selectFile(event) {
    this.selectedFiles = event.target.files;
    this.readThis(event.target);
  }

  readThis(inputValue: any): void {
    const file: File = inputValue.files[0];
    const myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      // you can perform an action with readed data here
      console.log(myReader.result);
    };

    myReader.readAsText(file);
  }

  upload(files: FileInfo[]) {
    Array.from(files).forEach(file => {
      this.uploadService.upload(file.file).subscribe(
        event => {
          if (event.type === HttpEventType.UploadProgress) {
            file.progress = Math.round(100 * event.loaded / event.total);
          } else if (event instanceof HttpResponse) {
            this.message = event.body.message;
            this.fileInfos = this.uploadService.getFiles();
            this.files = this.files.filter(item => !item.file.name === event.body.name);
          }
        },
        err => {
          this.progress = 0;
          this.message = 'Could not upload the file!';
          this.currentFile = undefined;
        });
    });
  }

  uploadFile(event) {
    const files = event;
    this.files = Array.from(files).map(file => new FileInfo(file, 0));
    this.upload(this.files);
  }

  deleteAttachment(index) {
    this.files.splice(index, 1);
  }
}
