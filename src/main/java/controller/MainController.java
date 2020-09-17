package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    AnchorPane maindisplay;
    public void showCreateBook(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/CreateEntities/showCreateBook.fxml"));
            maindisplay.getChildren().setAll(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showCreateAuthor(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/CreateEntities/showCreateAuthor.fxml"));

            maindisplay.getChildren().setAll(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showCreateUser(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/CreateEntities/showCreateUser.fxml"));
            maindisplay.getChildren().setAll(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showCreateReview(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/CreateEntities/showCreateReview.fxml"));
            maindisplay.getChildren().setAll(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showCreateRental(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/CreateEntities/showCreateRental.fxml"));
            maindisplay.getChildren().setAll(root);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showSearchBook(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/SearchEntities/showSearchBook.fxml"));
            maindisplay.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSearchAuthor(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/SearchEntities/showSearchAuthor.fxml"));
            maindisplay.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showSearchUser(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/SearchEntities/showSearchUser.fxml"));
            maindisplay.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showSearchReview(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/SearchEntities/showSearchReview.fxml"));
            maindisplay.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showSearchRental(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/SearchEntities/showSearchRental.fxml"));
            maindisplay.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitProgram(ActionEvent actionEvent) {
        System.exit(0);
    }
}
