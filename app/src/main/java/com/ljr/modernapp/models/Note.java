package com.ljr.modernapp.models;

import com.orm.SugarRecord;

/**
 * Created by ljr124 on 1/22/16.
 */
public class Note extends SugarRecord<Note> {

    private String title;
    private String content;
    private int color;
    private Long dateCreated;
    private Long dateModified;


    //required constructor
    public Note(){}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getDateModified() {
        return dateModified;
    }

    public void setDateModified(Long dateModified) {
        this.dateModified = dateModified;
    }
}
