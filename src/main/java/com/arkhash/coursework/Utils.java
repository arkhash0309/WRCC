package com.arkhash.coursework;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Utils {
    // checks if the string is null or empty
    public static boolean isEmpty(String text) {
        return (text == null || text.equals(""));
    }

    // checks if there are any special characters.
    public static boolean hasSpecialCharacters(String text) {
        // checks if the text is empty
        if (isEmpty(text)) return true;
        // go through every character
        char[] chars = text.toCharArray();
        for (char ch : chars) {
            if ((!Character.isLetter(ch)) && (ch != ' ')) {
                return true;
            }
        }
        return false;
    }

    // checks if there are any commas.
    public static boolean hasCommas(String text) {
        // checks if the text is empty
        if (isEmpty(text)) return true;
        // goes through every character
        char[] chars = text.toCharArray();
        for (char ch : chars) {
            // checks for comma
            if (ch == ',') return true;
        }
        return false;
    }

    // getNumber obtains the number entered by the user and
    // in case of exceptions returns -1
    public static int getNumber(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void dialog(String message, String title) throws IOException {
        Stage stage = new Stage();
        // loads the fxml file named dialog.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(WRCC.class.getResource("dialog.fxml"));
        // loads the new scene
        Scene scene = new Scene(fxmlLoader.load());
        Dialog dialog = fxmlLoader.getController();
        dialog.setMessage(message);
        // creates the title for the window
        stage.setTitle(title);
        // sets the scene to the stage
        stage.setScene(scene);
        // displays the stage
        stage.show();
    }

    // produces the error message to user in case of invalid info
    public static void errorDialog(String error) throws IOException {
        dialog(error,"Error!");
    }

    public static void successDialog(String success) throws IOException {
        dialog(success,"Success!");
    }
}
