package com.hektor7.noteTakingApp.controllers.ui;

import com.hektor7.noteTakingApp.controllers.BaseController;
import com.hektor7.noteTakingApp.model.Note;
import com.hektor7.noteTakingApp.ui.FXMLPage;
import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.util.Objects.nonNull;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import static javafx.scene.control.ButtonType.OK;


public class ListNotesUIController extends BaseController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Note> notesListTable;

    @FXML
    private TextField txSearchNotes;

    @FXML
    private TableColumn noteTitle;

    @FXML
    private TableColumn noteDescription;

    @FXML
    private Label lbNotesCount;

    @FXML
    private Button btnNewNote;

    @FXML
    private Button btnDeleteNote;

    @FXML
    private Button btnEditNote;

    @FXML
    void doDeleteNote(ActionEvent event) {

        Optional<ButtonType> result = this.alert.showAndWait();
        if (result.get().equals(OK)) {
            // user chose OK
            data.remove(this.getItem());
        }
    }

    @FXML
    void doEditNote(ActionEvent event) throws IOException {
        editNote = null;
        editNote = getItem();
        if (nonNull(editNote)) {
            this.navigate(event, FXMLPage.ADD.getPageUrl());
        }
    }

    @FXML
    void doNewNote(ActionEvent event) throws IOException {
        editNote = null;
        this.navigate(event, FXMLPage.ADD.getPageUrl());

    }

    /**
     * Get selected item from the list.
     *
     * @return selected note
     */
    private Note getItem() {
        return Note.class.cast(notesListTable.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.initializeTableHeader();
        this.initializeNotesCounter();
        this.initializeAlertBox();
        this.initializeFilter();


    }

    /**
     * Initialize Note's filter.
     */
    private void initializeFilter() {
    /*
     * Attach a KeyReleased action to searchNotes field, so when typing to
     * filter the notes currently attached to the table view.
     */
        FilteredList<Note> filteredData = new FilteredList<>(data, n -> true);
        this.txSearchNotes.setOnKeyReleased(e -> {
            filteredData.setPredicate(n -> {

                if (this.txSearchNotes.getText() == null || this.txSearchNotes.getText().isEmpty()) {
                    return true;
                }

                return n.getTitle().contains(this.txSearchNotes.getText())
                        || n.getDescription().contains(this.txSearchNotes.getText());
            });
        });

        this.notesListTable.setItems(filteredData);
    }

    /**
     * Initialize alert box for delete action
     */
    private void initializeAlertBox() {
        //Initializing the alert box
        this.alert = new Alert(CONFIRMATION);
        this.alert.setTitle("Confirmation Dialog");
        this.alert.setHeaderText("Look, a delete confirmation");
        this.alert.setContentText("Are you ok with deleting this note?");
    }

    /**
     * Initialize notes counter
     */
    private void initializeNotesCounter() {
        //Settings notes count
        this.lbNotesCount.textProperty().bind(Bindings.createStringBinding(() -> data.size() + " Note(s)", data));
    }

    /**
     * Initialize table header
     */
    private void initializeTableHeader() {
        this.noteTitle.setCellValueFactory(
                new PropertyValueFactory<>("title"));

        this.noteDescription.setCellValueFactory(
                new PropertyValueFactory<>("description"));
    }
}
