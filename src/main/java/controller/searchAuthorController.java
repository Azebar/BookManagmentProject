package controller;

import author.AuthorRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class searchAuthorController {

    @FXML
    private TextField searchTextInput;

    @FXML
    private ChoiceBox optionChoiceButton;

    @FXML
    public void searchAuthor (){

    }
    public void launchAuthorSearch(ActionEvent event){
        AuthorRepository authorRepository = new AuthorRepository();
        String choice = (String) optionChoiceButton.getValue();

        switch (choice) {
            case ("default"):
                searchTextInput.setPromptText("No  options selected");
                break;
            case ("Author last name"):
                //authorRepository.getAuthorByLastName(searchTextInput.getText());
                break;
            case ("Book"):
                break;
            case ("Country"):
                break;
            case ("Reference Number"):
                break;
        }



    }

    public void checkIfFieldEmpty(){
        if (searchTextInput.getText().trim().isEmpty()){
            searchTextInput.setPromptText("No input. Please try again");
        }
    }
}
