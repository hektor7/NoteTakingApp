package com.hektor7.noteTakingApp.ui;

import java.net.URL;

/**
 * Created by hector on 20/08/15.
 */
public enum FXMLPage {

    LIST("/com/hektor7/noteTakingApp/ui/fxml/ListNotesUI.fxml"),
    ADD("/com/hektor7/noteTakingApp/ui/fxml/AddEditUI.fxml");

    private String page;

    FXMLPage(String page) {
        this.page = page;
    }

    /**
     * It gets page's URL.
     *
     * @return an URL object
     */
    public URL getPageUrl() {
        return getClass().getResource(this.page);

    }
}
