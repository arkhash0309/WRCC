package com.arkhash.coursework;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;

public class Dialog {
    @FXML
    private DialogPane dialog;

    public void setMessage(String msg) {
        this.dialog.setContentText(msg);
    }
}
