package com.back.appnotesback.service;

import com.back.appnotesback.dto.NoteDTO;
import com.back.appnotesback.entity.Note;

import java.util.List;

public interface INoteService {

    public List<NoteDTO> listAll();

    public Note createNote(NoteDTO noteDTO);

    public void deleteNote(Long note);

    public NoteDTO findByNote(Long note);

    public List<?> searchNote(String search);
}
