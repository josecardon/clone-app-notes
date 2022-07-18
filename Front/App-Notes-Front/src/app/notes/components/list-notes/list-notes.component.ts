import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { INote } from '../../intefaces/inote';
import { NoteService } from '../../services/note.service';

@Component({
  selector: 'app-list-notes',
  templateUrl: './list-notes.component.html',
  styleUrls: ['./list-notes.component.less'],
})
export class ListNotesComponent implements OnInit {
  @Input() notes: INote[] = [];
  @Input() search: any | boolean;
  public listDataNotes: INote[] = [];
  public getDate: Date = new Date();
  public changeColor: string = '#fef68a';
  public color: string = '#fef68a';
  public saveData: INote = {
    noteId: 0,
    title: '',
    description: ''
  }

  // public formDocuments = this._formBuilder.group({
  //   inputNameDoc:[""],
  //   inputCode:[""]


  // });


  public saveNote(): void {

    if(this.saveData.title === '' && this.saveData.description === ''){
      return;
    } else {
      const note: INote = {
        noteId: this.saveData.noteId,
        title: this.saveData.title,
        description: this.saveData.description,
        color: this.color,

      }

      this.noteService.saveNote(note).subscribe((note) => {
        //this.notes.push(note);
        this.listNotes();
        this.saveData = {
          title: '',
          description: ''
        }
        this.color = '#fef68a';
      });
    }
  }

  public edit(noteId: number) {
    this.noteService.getNoteById(noteId).subscribe((note: INote) => {
      console.log(note);
      this.saveData = {
        noteId: note.noteId,
        title: note.title,
        description: note.description
      }
      //this.getDate = note.dateModification;
      this.changeColor = note.color;

    });
  }

  constructor( private noteService: NoteService) {}

  ngOnInit(): void {
    if (this.search) {
      this.notes = this.listDataNotes;
    } else {
      this.listNotes();
    }
  }

  public getColor(color: string): string {
    console.log(color)
    this.changeColor = color;
    this.color = color;
    return color;
  }

  ngAfterViewInit(): void {}

  public listNotes(): void {
    this.noteService.listNotes().subscribe((notes) => {
      this.notes = notes;
      this.listDataNotes = notes;
      console.log(notes);
    });
  }

  public deleteNote(note: number): void {
    this.noteService.deleteNote(note).subscribe(() => {
      //delete note from arrays
      this.notes = this.notes.filter((n) => n.noteId !== note);
      //this.listNotes();
    });
  }
}
