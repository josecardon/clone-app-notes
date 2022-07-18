package com.back.appnotesback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Note implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noteId;

    private String title;

    private String description;

    private String color;

    private Date dateCreation;

    private Date dateModification;

    private Integer changesUpdate;

    public Note() {

    }

    public Note(Long noteId, String title, String description, String color, Date dateCreation, Date dateModification, Integer changesUpdate) {
        this.noteId = noteId;
        this.title = title;
        this.description = description;
        this.color = color;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.changesUpdate = changesUpdate;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Integer getChangesUpdate() {
        return changesUpdate;
    }

    public void setChangesUpdate(Integer changesUpdate) {
        this.changesUpdate = changesUpdate;
    }
}
