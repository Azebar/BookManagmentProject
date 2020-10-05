package controller;

import author.AuthorEntity;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

;

public class displayAuthorController {

    AuthorEntity author;

    @FXML
    private TextField authorID;

    @FXML
    private TextField authorFirstName;

    @FXML
    private TextField authorLastName;

    @FXML
    private TextField authorDateOfBirth;

    @FXML
    private TextField authorCountry;

    @FXML
    private TextField authorBooks;


    public displayAuthorController(AuthorEntity author) {
        this.author = author;
        displayAuthor();
    }

    public displayAuthorController() {
    }

    public void initialize() {
        authorID.setText(String.valueOf(author.getAuthorId()));
        authorFirstName.setText(author.getFirstName());
        authorLastName.setText(author.getLastName());
        authorDateOfBirth.setText(String.valueOf(author.getDateOfBirth()));
        authorCountry.setText(author.getCountry());
        authorBooks.setText(author.getCountry());

    }



    public void displayAuthor(){


    }



    public void deleteAuthor(){

    }

    public void updateAuthor(){

    }


}
