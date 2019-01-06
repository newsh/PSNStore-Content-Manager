package de.newsh.title.view;

import java.io.IOException;
import java.util.ArrayList;

import de.newsh.title.model.Title;
import de.newsh.util.URLFetcher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TitleEditDialogController {
	
	@FXML
	private TextField urlField;
	@FXML
	private TextField nameField;
	@FXML
	private CheckBox ps4Checkbox;
	@FXML
	private CheckBox ps3Checkbox;
	@FXML
	private CheckBox psvitaCheckbox;
	@FXML
	private CheckBox pspCheckbox;
	@FXML
	private TextField priceField;
	@FXML
	private DatePicker datePicker;
	
	private Stage dialogStage;
	private Title title;
	private boolean okClicked = false;
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
	
	
	@FXML
	private void initialize() {
	}
	/**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public void setTitle(Title title) {
		this.title = title;
		
		urlField.setText(title.getStoreUrl());
		nameField.setText(title.getName());
		if(title.getPlatform() != null) {
			if(title.getPlatform().contains("PS4"))
				ps4Checkbox.setSelected(true);
			if(title.getPlatform().contains("PS3"))
				ps3Checkbox.setSelected(true);
			if(title.getPlatform().contains("PS Vita"))
				psvitaCheckbox.setSelected(true);
			if(title.getPlatform().contains("PSP"))
				pspCheckbox.setSelected(true);
		}
		datePicker.setValue(title.getReleaseDate());
		priceField.setText(String.valueOf(title.getPrice()));
	}
    public boolean isOkClicked() {
        return okClicked;
    }
    @FXML
    private void handleOk() {

        if (inputIsValid()) {
	    	title.setStoreUrl(urlField.getText());
        	title.setName(nameField.getText());
	    	title.setPlatform(checkCheckBoxes());
	    	title.setReleaseDate(datePicker.getValue());
	    	title.setPrice(priceField.getText());
	    	
	    	okClicked = true;
	    	dialogStage.close();
        } else {
        	sendErrorMessage("Please enter a name");
        }
    }
    @FXML
    private void handleCancel() {
    	dialogStage.close();
    }
    @FXML
    private void handleFetchDataButton() throws IOException {
    	Title fetchedTitle = URLFetcher.fetchTitleByUrl(urlField.getText());
    	if(fetchedTitle == null) {
    		sendErrorMessage("Url not valid.");
    		return;
    	}
    	//this.setTitle(fetchedTitle); doesn't work. why though?
    	clearAllFields();
    	nameField.setText(fetchedTitle.getName());
    	if(fetchedTitle.getPlatform() != null) {
			if(fetchedTitle.getPlatform().contains("PS4"))
				ps4Checkbox.setSelected(true);
			if(fetchedTitle.getPlatform().contains("PS3"))
				ps3Checkbox.setSelected(true);
			if(fetchedTitle.getPlatform().contains("PS Vita"))
				psvitaCheckbox.setSelected(true);
			if(fetchedTitle.getPlatform().contains("PSP"))
				pspCheckbox.setSelected(true);
		}
		datePicker.setValue(fetchedTitle.getReleaseDate());
		priceField.setText(String.valueOf(fetchedTitle.getPrice()));
    	
    }
    private void clearAllFields() {
    	
		nameField.clear();
		ps4Checkbox.setSelected(false);
		ps3Checkbox.setSelected(false);
		psvitaCheckbox.setSelected(false);
		pspCheckbox.setSelected(false);
		datePicker.setValue(null);;
		
	}
	private boolean inputIsValid() {
		return !nameField.getText().isEmpty();
    }
	private void sendErrorMessage(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
        alert.initOwner(dialogStage);
        alert.setHeaderText(msg);
        alert.showAndWait();
	}
    private String checkCheckBoxes() {
		ArrayList<String> platformList = new ArrayList<>();
		if(ps4Checkbox.isSelected())
    		platformList.add("PS4");
		if(ps3Checkbox.isSelected())
    		platformList.add("PS3");
    	if(psvitaCheckbox.isSelected())
    		platformList.add("PS Vita");
    	if(pspCheckbox.isSelected())
    		platformList.add("PSP");
		return String.join(", ", platformList);
	}
}
    
