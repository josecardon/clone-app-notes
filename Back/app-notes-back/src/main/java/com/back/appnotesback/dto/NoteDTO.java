package com.back.appnotesback.dto;

import java.io.Serializable;
import java.util.Date;

public class NoteDTO implements Serializable {

    private Long noteId;

    private String title;

    private String description;

    private String color;

    private Date dateCreation;

    private Date dateModification;

    private Integer changesUpdate;

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getChangesUpdate() {
        return changesUpdate;
    }

    public void setChangesUpdate(Integer changesUpdate) {
        this.changesUpdate = changesUpdate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}
