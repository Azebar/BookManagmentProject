package controller;


import book.BookEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class createBookController {

    @FXML
    private Button confirm;

    @FXML
    private TextField author;

    @FXML
    private TextField realeaseYear;

    @FXML
    private TextField title;

    @FXML
    private TextField genre;

    @FXML
    private Button cancel;

    @FXML
    void createBook(ActionEvent event) {
        BookEntity book = new BookEntity();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}