package controller;

import author.AuthorEntity;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class searchAuthorResultsController implements Initializable {

    @FXML private TableView<List<AuthorEntity>> authorsTable;
    @FXML private TableColumn<AuthorEntity, StringProperty> referenceColumn;
    @FXML private TableColumn<AuthorEntity, StringProperty> firstNameColumn;
    @FXML private TableColumn<AuthorEntity, StringProperty> lastNameColumn;
    @FXML private TableColumn<AuthorEntity, StringProperty> countryColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        referenceColumn.setCellValueFactory(new PropertyValueFactory<AuthorEntity, StringProperty>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<AuthorEntity, StringProperty>("first_name"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<AuthorEntity, StringProperty>("last_name"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<AuthorEntity, StringProperty>("country"));

        authorsTable.getItems().setAll(parseUserList());
    }
    private List<AuthorEntity> parseUserList(){
        // parse and construct User dataModel list by looping your ResultSet rs
        // and return the list
        return null;
    }
}