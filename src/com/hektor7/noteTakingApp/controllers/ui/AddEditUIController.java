package com.hektor7.noteTakingApp.controllers.ui;

import com.hektor7.noteTakingApp.controllers.BaseController;
import com.hektor7.noteTakingApp.model.Note;
import com.hektor7.noteTakingApp.ui.FXMLPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.nonNull;
import static javafx.scene.control.Alert.AlertType.WARNING;

public class AddEditUIController extends BaseController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNotesList;

    @FXML
    private TextField txNoteTitle;

    @FXML
    private TextArea txNoteDescription;

    @FXML
    private Button btnCancelEdit;

    @FXML
    private Button btnClearEdit;

    @FXML
    private Button btnSaveEdit;

    @FXML
    void doCancel(ActionEvent event) throws IOException {
        this.navigate(event, FXMLPage.LIST.getPageUrl());
    }

    @FXML
    void doClear(ActionEvent event) {
        this.txNoteTitle.clear();
        this.txNoteDescription.clear();
    }

    @FXML
    void doNotesList(ActionEvent event) throws IOException {
        this.navigate(event, FXMLPage.LIST.getPageUrl());
    }

    @FXML
    void doSave(ActionEvent event) throws IOException {
        if (nonNull(editNote))
            data.remove(editNote);

        if (this.txNoteDescription.getText().trim().equals("")
                || this.txNoteTitle.getText().trim().equals("")) {
            this.alert.showAndWait();
            return;
        }

        data.add(new Note(this.txNoteTitle.getText(), this.txNoteDescription.getText()));
        this.navigate(event, FXMLPage.LIST.getPageUrl());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.alert = new Alert(WARNING);
        this.alert.setTitle("Warning Dialog");
        this.alert.setHeaderText("Invalid data to save or update!");
        this.alert.setContentText("Note title or description can not be empty!");

        if (nonNull(editNote)) {
            this.txNoteTitle.setText(editNote.getTitle());
            this.txNoteDescription.setText(editNote.getDescription());
            this.btnSaveEdit.setText("Update");
        }
    }
}
