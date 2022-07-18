package com.back.appnotesback.repository;

import com.back.appnotesback.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository  extends JpaRepository<Note, Long> {

    public Note findByNoteId (Long note);

    public List<Note> findByTitleContaining (String search);
}
