package com.hektor7.noteTakingApp.controllers;

import com.hektor7.noteTakingApp.model.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Created by hector on 20/08/15.
 */
public class BaseController {

    protected static ObservableList<Note> data = FXCollections.<Note>observableArrayList(
            new Note("Note 1", "Description of note 41"),
            new Note("Note 2", "Description of note 32"),
            new Note("Note 3", "Description of note 23"),
            new Note("Note 4", "Description of note 14"));

    protected Alert alert;

    protected static Note editNote = null;

    /**
     * Method to navigate between modules based on an event and an URL.
     *
     * @param event       event when navigation occurs
     * @param fxmlDocName destination
     * @throws IOException when errors occurs
     */
    protected void navigate(Event event, URL fxmlDocName) throws IOException {
        //Loading new fxml UI document
        Parent pageParent = FXMLLoader.load(fxmlDocName);
        //Creating new scene
        Scene scene = new Scene(pageParent);
        //get current stage
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //Hide old stage
        appStage.hide(); // Optional
        //Set stage with new Scene
        appStage.setScene(scene);
        //Show up the stage
        appStage.show();
    }
}
