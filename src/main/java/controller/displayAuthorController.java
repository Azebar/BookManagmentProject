package controller;

import author.AuthorEntity;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

;

public class displayAuthorController {

    AuthorEntity author;

    @FXML
    private TextField AuthorID;

    @FXML
    private TextField AuthorFirstName;

    @FXML
    private TextField AuthorLastName;

    @FXML
    private TextField AuthorDateOfBirth;

    @FXML
    private TextField AuthorCountry;

    @FXML
    private TextField AuthorBooks;


    public displayAuthorController(AuthorEntity author) {
        this.author = author;
        displayAuthor();
    }



    public void displayAuthor(){

//        AuthorID.setText(String.valueOf(author.getAuthorId()));
//        AuthorFirstName.setText(author.getFirstName());
//        AuthorLastName.setText(author.getLastName());
//        AuthorDateOfBirth.setText(String.valueOf(author.getDateOfBirth()));
//        AuthorCountry.setText(author.getCountry());
//        AuthorBooks.setText(author.getCountry());
    }



    public void deleteAuthor(){

    }

    public void updateAuthor(){

    }
}
