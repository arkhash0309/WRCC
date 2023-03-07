package com.arkhash.coursework;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;

public class ErrorDialog {
    @FXML
    private DialogPane errorDialog;

    public void setMessage(String msg) {
        this.errorDialog.setContentText(msg);
    }
}
