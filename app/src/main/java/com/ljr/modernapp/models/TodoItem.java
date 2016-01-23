package com.ljr.modernapp.models;

import com.orm.SugarRecord;

/**
 * Created by ljr124 on 1/22/16.
 */
public class TodoItem extends SugarRecord<TodoItem> {

    private String title;
    private boolean checked;
    private Long dateCreated;
    private Long dateModified;

    //required constructor
    public TodoItem(){}



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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
