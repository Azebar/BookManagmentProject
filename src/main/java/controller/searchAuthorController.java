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
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.DBHandler;


public class searchAuthorController {

    private ObservableList<AuthorEntity> authorsObservableList = FXCollections.observableArrayList();

    @FXML
    private TextField searchTextInput;

    @FXML
    private ChoiceBox<String> optionChoiceButton;

    @FXML
    private TableView<AuthorEntity> authorsTable;

    @FXML
    private TableColumn<AuthorEntity, Integer> referenceColumn;

    @FXML
    private TableColumn<AuthorEntity, String> firstNameColumn;

    @FXML
    private TableColumn<AuthorEntity, String> lastNameColumn;

    @FXML
    private TableColumn<AuthorEntity, String> countryColumn;

    @FXML
    public void searchAuthor (){

    }
    public void initialize() {
        referenceColumn.setCellValueFactory(new PropertyValueFactory<>("authorId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
    }

    public void loadTableView(ObservableList<AuthorEntity> authorsObservableList){
        authorsTable.setItems(authorsObservableList);
    }

    public ObservableList<AuthorEntity> getAuthorEntityObservableList(){
        return authorsObservableList;
    }


    public void inputAuthorSearch(ActionEvent event){
        AuthorRepository authorRepository = new AuthorRepository();
        String choice = optionChoiceButton.getValue();

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
               loadTableView(getAuthorEntityObservableList());
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

    public void searchAuthorByID(AuthorRepository authorRepository){

        try{
            String idString = searchTextInput.getText();
            int id =Integer.parseInt(idString);
            Session session = DBHandler.getSessionFactory().openSession();
            //String sql = "SELECT * FROM authors WHERE id = :authorID";
            String queryString = "from AuthorEntity a where a.authorId = :authorId";
            Query<AuthorEntity> query = session.createQuery(queryString);
            query.setParameter("authorId", id);
            authorsObservableList.addAll(query.list());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void launchDisplayAuthor (AuthorEntity author){

    }

    public void checkIfFieldEmpty(){
        if (searchTextInput.getText().trim().isEmpty()){
            searchTextInput.setPromptText("No input. Please try again");
        }
    }
}
