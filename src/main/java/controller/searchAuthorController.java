package controller;

import author.AuthorEntity;
import author.AuthorRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.DBHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class searchAuthorController {

    @FXML
    private TextField searchTextInput;

    @FXML
    private ChoiceBox optionChoiceButton;

    private ObservableList<AuthorEntity> authorsObservableList;

    @FXML
    private TableView<AuthorEntity> authorsTable;

    @FXML
    private TableColumn<AuthorEntity, String> referenceColumn;

    @FXML
    private TableColumn<AuthorEntity, String> firstNameColumn;

    @FXML
    private TableColumn<AuthorEntity, String> lastNameColumn;

    @FXML
    private TableColumn<AuthorEntity, String> countryColumn;

    @FXML
    public void searchAuthor (){

    }

    public void inputAuthorSearch(ActionEvent event){
        AuthorRepository authorRepository = new AuthorRepository();
        String choice = (String) optionChoiceButton.getValue();

        switch (choice) {
            case ("default"):
                searchTextInput.setPromptText("No  options selected");
                break;
            case ("Author last name"):
                searchAuthorByLastName();
                break;
            case ("Book"):
                searchAuthorsByBook();
                break;
            case ("Country"):
                searchAuthorByCountry();
                break;
            case ("Reference number"):
               searchAuthorByID(authorRepository);
                break;
            default:
                searchTextInput.setPromptText("No matching author found");
                break;
        }
    }

    public void searchAuthorsByBook(){

    }

    public void searchAuthorByLastName(){

    }

    public void searchAuthorByCountry(){

    }

    public ResultSet searchAuthorByID(AuthorRepository authorRepository){
        Connection c;
        data = FXCollections.observableArrayList();

        try{
            String idString = searchTextInput.getText();
            int id =Integer.parseInt(idString);
            Session session = DBHandler.getSessionFactory().openSession();
            PreparedStatement ps = session.con
            String sql = "SELECT * FROM authors where id = authorID;";
            SQLQuery query =  session.createSQLQuery(sql);
            query.setInteger("authorID", id);
            List<AuthorEntity> authorsResults = query.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void launchDisplayAuthor (AuthorEntity author){

    }

    public void checkIfFieldEmpty(){
        if (searchTextInput.getText().trim().isEmpty()){
            searchTextInput.setPromptText("No input. Please try again");
        }
    }
}
