package com.back.appnotesback.service;


import com.back.appnotesback.dto.NoteDTO;
import com.back.appnotesback.entity.Note;
import com.back.appnotesback.repository.NoteRepository;
import com.back.appnotesback.transformer.NoteTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional
@Service
public class INoteServiceImp implements INoteService {

    private NoteRepository repository;

    @Autowired
    public INoteServiceImp(NoteRepository noteRepository) {
        this.repository = noteRepository;
    }


    @Override
    public List<?> searchNote(String search) {
        return (List<?>) repository.findByTitleContaining(search);
    }

    @Override
    public List<NoteDTO> listAll() {
        return (List<NoteDTO>) repository.findAll().stream().map(NoteTransformer::getNoteDTOFromNote).collect(Collectors.toList());
    }

    @Override
    public Note createNote(NoteDTO noteDTO) {
        Note saveNote = new Note();
        Date date = new Date();
        Integer count = null;

        if(noteDTO.getNoteId() != null) {

            Note getNote = repository.findByNoteId(noteDTO.getNoteId());
            Integer totalCount = getNote.getChangesUpdate();
            saveNote.setNoteId(getNote.getNoteId());
            saveNote.setDateCreation(getNote.getDateCreation());
            saveNote.setTitle(noteDTO.getTitle());
            saveNote.setDateModification(date);
            saveNote.setColor(getNote.getColor());
            saveNote.setChangesUpdate(totalCount + 1);
            saveNote.setDescription(getNote.getDescription());
        } else {
            count = 0;
            saveNote.setChangesUpdate(count);
            saveNote.setNoteId(noteDTO.getNoteId());
            saveNote.setDateCreation(date);
            saveNote.setTitle(noteDTO.getTitle());
            saveNote.setColor(noteDTO.getColor());
            saveNote.setDateModification(noteDTO.getDateModification());
            saveNote.setDescription(noteDTO.getDescription());
        }

        return repository.save(saveNote);

    }

    @Override
    public void deleteNote(Long note) {
        repository.deleteById(note);
    }

    @Override
    public NoteDTO findByNote(Long note) {
        Optional<Note> getId = repository.findById(note);
        return NoteTransformer.getNoteDTOFromNote(getId.orElse(null));
    }
}
