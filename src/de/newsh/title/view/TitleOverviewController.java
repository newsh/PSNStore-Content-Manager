package de.newsh.title.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;


import de.newsh.title.MainApp;
import de.newsh.title.model.Title;

public class TitleOverviewController {
    @FXML
    private TableView<Title> titleTable;
    @FXML
    private TableColumn<Title, String> nameColumn;
    @FXML
    private TableColumn<Title, String> platformColumn;
    @FXML
    private TableColumn<Title, String> priceColumn;
    
    @FXML
    private Text nameText;
    @FXML
    private Label platformLabel;
    @FXML
    private Label releaseDateLabel;
    @FXML 
    private Label priceLabel;

    @FXML
    private Button newButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private ImageView imageView;
    @FXML
    private AnchorPane titleDetailsAnchorPane;
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public TitleOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     * @throws IOException 
     */
    @FXML
    private void initialize() throws IOException {
        
    	editButton.setDisable(true);
    	deleteButton.setDisable(true);
    	
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        platformColumn.setCellValueFactory(cellData -> cellData.getValue().platformProperty());
        priceColumn.setCellValueFactory(cellData-> cellData.getValue().priceProperty());
        // Clear title details.
        showTitleDetails(null);
     // Listen for selection changes and show the title details when changed.
        titleTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> { 
                	try {
						showTitleDetails(newValue);
					} catch (IOException e) {
						e.printStackTrace();
					}
                	editButton.setDisable(false);
                	deleteButton.setDisable(false);
                	
                });
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Add observable list data to the table
        titleTable.setItems(mainApp.getTitleData());
    }
    /**
     * Fills all text fields to show details about the title.
     * If the specified title is null, all text fields are cleared.
     * 
     * @param titl the title or null
     * @throws IOException 
     */
    private void showTitleDetails(Title title) throws IOException {
    	nameText.setText("");
        platformLabel.setText("");
        releaseDateLabel.setText("");
    	priceLabel.setText("");
    	imageView.setImage(null);
    	if (title != null) {
            // Fill the labels with info from the title object.
            nameText.setText(title.getName());
            platformLabel.setText(title.getPlatform());
            if(title.getReleaseDate() != null)
            	releaseDateLabel.setText(title.getReleaseDate().toString());
            priceLabel.setText(title.getPrice());
            
            String pathToCover = "resources/titleCover/" + title.getCID() + ".jpg";
            if(new File(pathToCover).isFile()) {
	            FileInputStream input = new FileInputStream(pathToCover);
	            Image image = new Image(input);
	            imageView.setImage(image);
            }
        }
    }
    @FXML
    private void handleDeleteTitle() {
    	int selectedIndex = titleTable.getSelectionModel().getSelectedIndex();
    	if (selectedIndex >= 0) {
        	
        	titleTable.getItems().remove(selectedIndex);
            mainApp.saveTitleDataToCurrentFile();
            if(titleTable.getItems().isEmpty()) {
            	editButton.setDisable(true);
        		deleteButton.setDisable(true);
            }
            
        } else {
            // Nothing selected. Should not ever happen because edit/delete are disabled
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Title Selected");
            alert.setContentText("Please select a title first.");

            alert.showAndWait();
        }
    }
    @FXML
    private void handleNewTitle() throws IOException {
        Title tempTitle = new Title();
        boolean okClicked = mainApp.showTitleEditDialog(tempTitle);
        if (okClicked) {
            mainApp.getTitleData().add(tempTitle);
            mainApp.saveTitleDataToCurrentFile();
            
        }
    }
	

	@FXML
	private void handleEditTitle() throws IOException {
		Title selectedTitle = titleTable.getSelectionModel().getSelectedItem();
		if (selectedTitle == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setContentText("Please select a title first.");
			alert.showAndWait();
		} else {
			mainApp.showTitleEditDialog(selectedTitle);
			mainApp.saveTitleDataToCurrentFile();
		}
	}
}