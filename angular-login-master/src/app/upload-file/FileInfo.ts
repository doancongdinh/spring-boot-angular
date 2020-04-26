export class FileInfo {
  file: File;
  progress: number;

  constructor(file, progress) {
    this.file = file;
    this.progress = progress;
  }
}
