package com.back.appnotesback.controller;


import com.back.appnotesback.dto.NoteDTO;
import com.back.appnotesback.entity.Note;
import com.back.appnotesback.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class NoteController {

    public INoteService noteService;

    @Autowired
    public NoteController(INoteService iNoteService) {
        this.noteService = iNoteService;
    }

    @GetMapping(value = "/note")
    public ResponseEntity<List<NoteDTO>> listAllNote() {
        return ResponseEntity.status(200).body(noteService.listAll());
    }

    @GetMapping(value = "/note-search")
    public ResponseEntity<List<?>> searchNote(@RequestParam(value = "query") String note) {
        return ResponseEntity.status(200).body(noteService.searchNote(note));
    }


    @PostMapping(value = "/note")
    public ResponseEntity<Note> createNote(@RequestBody NoteDTO noteDTO) {
        return new ResponseEntity<>(noteService.createNote(noteDTO), HttpStatus.CREATED);
    }


    @GetMapping(value = "/note-id/{id}")
    public ResponseEntity<NoteDTO> getNote(@PathVariable Long id) {
        return ResponseEntity.status(200).body(noteService.findByNote(id));
    }

    @DeleteMapping(value = "/note-delete/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }




}
