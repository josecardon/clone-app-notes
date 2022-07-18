import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { INote } from '../../intefaces/inote';
import { NoteService } from '../../services/note.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less'],
})
export class HomeComponent implements OnInit {
  public dataNote: INote[] = [];
  public noFound: boolean = false;

  constructor(private noteService: NoteService) {}

  ngOnInit(): void {}

  getSearch(query: string) {
    if (query === '') {
      return
    } else {
      this.noFound = false;

      this.noteService.searchNote(query).subscribe((res: INote[]): void => {
        if (res.length === 0) {
          this.noFound = true;
        } else {
          this.dataNote = res;
        }

        console.log('Query==>', res);
      });
    }
  }
}
