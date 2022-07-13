package com.back.appnotesback.transformer;

import com.back.appnotesback.dto.NoteDTO;
import com.back.appnotesback.entity.Note;

public class NoteTransformer {

    public static NoteDTO getNoteDTOFromNote (Note note) {
        if(note ==null) {
            return null;
        }
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setNoteId(note.getNoteId());
        noteDTO.setTitle(note.getTitle());
        noteDTO.setDescription(note.getDescription());
        noteDTO.setDateCreation(note.getDateCreation());
        noteDTO.setDateModification(note.getDateModification());
        noteDTO.setColor(note.getColor());

        return noteDTO;

    }

    public static Note getNoteDTOFromNote (NoteDTO noteDTO) {
        if(noteDTO ==null) {
            return null;
        }
        Note note = new Note();
        note.setNoteId(noteDTO.getNoteId());
        note.setTitle(noteDTO.getTitle());
        note.setDescription(noteDTO.getDescription());
        note.setDateCreation(noteDTO.getDateCreation());
        note.setDateModification(noteDTO.getDateModification());
        note.setColor(noteDTO.getColor());

        return note;

    }
}
