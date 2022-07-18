import { environment } from './../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { INote } from '../intefaces/inote';

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  constructor(private http: HttpClient) { }

  public searchNote(note: string): Observable<INote[] | INote | any> {
   return this.http.get<INote[] | INote | any>(`${environment.END_POINT}/note-search?query=${note}`);
  }

  public listNotes(): Observable<INote[] | any> {
    return this.http.get<INote[] | any>(`${environment.END_POINT}/note`);
  }

  public deleteNote(note: INote | number): Observable<INote | any | void> {
    return this.http.delete<INote | any | void>(`${environment.END_POINT}/note-delete/${note}`);
  }

  public saveNote(note: INote): Observable<INote | any> {
    return this.http.post<INote | any>(`${environment.END_POINT}/note`, note);
  }

  //get note by identifiers
  public getNoteById(note: INote | number): Observable<INote | any> {
    return this.http.get<INote | any>(`${environment.END_POINT}/note-id/${note}`);
  }
}
