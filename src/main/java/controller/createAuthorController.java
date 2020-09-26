package controller;

import author.AuthorEntity;
import author.AuthorRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;

public class createAuthorController {

        @FXML
        private Button confirm;

        @FXML
        private TextField firstName;

        @FXML
        private TextField lastName;

        @FXML
        private TextField country;

        @FXML
        private TextField dateOfBirth;

        @FXML
        private Button cancel;

        @FXML
        public void createAuthor(ActionEvent actionEvent){
            String firstNameHelper;
            String lastNameHelper;
            String countryHelper;
            Date dateOfBirthHelper;

            if (checkIfFieldIsEmpty() == false) {
                firstNameHelper = firstName.getText();
                lastNameHelper = lastName.getText();
                countryHelper = country.getText();
                dateOfBirthHelper = parseDateOfBirthFromTextField();
                AuthorEntity author = new AuthorEntity(firstNameHelper,lastNameHelper,dateOfBirthHelper, countryHelper);
                createAuthorInRepository(author);
            }
    }

    public boolean checkIfFieldIsEmpty(){
        boolean isEmpty = false;

        if (firstName.getText() == null||firstName.getText().trim().isEmpty()){
            firstName.setText("Please input first name");
            isEmpty = true;
        }

        if (lastName.getText() == null||lastName.getText().trim().isEmpty()){
            lastName.setText("Please input last name");
            isEmpty = true;
        }

        if (country.getText() == null||country.getText().trim().isEmpty()){
            country.setPromptText("Please input country");
            isEmpty = true;
        }

        if (dateOfBirth.getText() == null||dateOfBirth.getText().trim().isEmpty()){
            dateOfBirth.setPromptText("Please input date of birth");
            isEmpty = true;
        }
        return isEmpty;
    }

    public Date parseDateOfBirthFromTextField(){
            Date date = new Date();

            try{
                date = new SimpleDateFormat("yyyy-mm-dd").parse(dateOfBirth.getText());
            }catch (Exception e){
                dateOfBirth.setText("");
                dateOfBirth.setPromptText("Incorrect format (yyyy-mm-dd)");
            }
            return date;
    }

    public void createAuthorInRepository(AuthorEntity author){
            try{
                AuthorRepository authorRepository = new AuthorRepository();
                authorRepository.createAuthor(author);
            }catch (Exception e){
                e.printStackTrace();
            }
    }

}
