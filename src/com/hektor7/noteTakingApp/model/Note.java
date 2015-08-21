package com.hektor7.noteTakingApp.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by hector on 21/08/15.
 */
public class Note {
    private final SimpleStringProperty title;
    private final SimpleStringProperty description;

    public Note(String title, String description) {
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
