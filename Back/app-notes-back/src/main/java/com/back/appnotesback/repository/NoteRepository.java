package com.back.appnotesback.repository;

import com.back.appnotesback.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository  extends JpaRepository<Note, Long> {

    public Note findByNoteId (Long note);
}
