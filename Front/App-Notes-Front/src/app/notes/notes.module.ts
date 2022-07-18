import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchNoteComponent } from './components/search-note/search-note.component';
import { ListNotesComponent } from './components/list-notes/list-notes.component';
import { HomeComponent } from './screens/home/home.component';
import { MaterialModule } from '../material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [SearchNoteComponent, ListNotesComponent, HomeComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  exports: [
    HomeComponent
  ]
})
export class NotesModule { }
