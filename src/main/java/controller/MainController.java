package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    AnchorPane maindisplay;
    public void showCreateBook(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/showCreateBook.fxml"));
            maindisplay.getChildren().setAll(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
