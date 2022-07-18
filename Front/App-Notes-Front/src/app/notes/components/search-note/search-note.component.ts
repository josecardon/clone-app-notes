import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import {debounceTime, distinctUntilChanged, filter, map, tap} from 'rxjs/operators';
import { NoteService } from '../../services/note.service';


@Component({
  selector: 'app-search-note',
  templateUrl: './search-note.component.html',
  styleUrls: ['./search-note.component.less']
})
export class SearchNoteComponent implements OnInit {
  public inputSearch: FormControl = new FormControl();
  @Output() setSearch = new EventEmitter<string>();
  constructor() { }

  ngOnInit(): void {
    this.onChange();
  }


  public onChange():void {
    this.inputSearch.valueChanges.pipe(
      map((search) => search.trim()),
      debounceTime(500),
      //Metodo para no repetir la busqueda si ya existe una busqueda en curso
      distinctUntilChanged(),
      // filter((search) => search !== ''),
      tap(res => {
        this.setSearch.emit(res);
        console.log('Busqueda==>', res);

      })
    ).subscribe();
  }


}
