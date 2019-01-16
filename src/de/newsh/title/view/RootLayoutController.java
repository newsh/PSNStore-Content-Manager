package de.newsh.title.view;

import de.newsh.title.MainApp;

import java.io.File;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.FileChooser;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Marco Jakob (edited)
 *
 */
public class RootLayoutController {

	// Reference to the main application
	private MainApp mainApp;
	@FXML
	Menu recentlyUsedMenu;

	@FXML
	private void initialize() {
	}

	@FXML
	private void initRecentlyUsedMenu() {
		recentlyUsedMenu.getItems().clear();
		for (String path : mainApp.getLastOpenedFiles()) {
			MenuItem menuItem = new MenuItem(path);
			recentlyUsedMenu.getItems().add(menuItem);
			menuItem.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if (mainApp.unsavedChangesDetected()) {
						if (showUnsavedChangesDialog() == ButtonData.CANCEL_CLOSE)
							return;
					}
					mainApp.loadTitleDataFromFile(new File(menuItem.getText()));
					initRecentlyUsedMenu();
				}
			});

		}

	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		initRecentlyUsedMenu();
	}

	/**
	 * Creates an empty title list.
	 */
	@FXML
	private void handleNew() {
		if (mainApp.unsavedChangesDetected()) {
			if (showUnsavedChangesDialog() == ButtonData.CANCEL_CLOSE)
				return;
		}
		mainApp.getTitleData().clear();
		mainApp.setTitleFilePath(null);
	}

	/**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	@FXML
	private void handleOpen() {
		if (mainApp.unsavedChangesDetected()) {
			if (showUnsavedChangesDialog() == ButtonData.CANCEL_CLOSE)
				return;
		}
		FileChooser fileChooser = new FileChooser();
		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
		if (file != null) {
			mainApp.loadTitleDataFromFile(file);
			initRecentlyUsedMenu();
		}
	}

	/**
	 * Saves the file to the games file that is currently open. If there is no open
	 * file, the "save as" dialog is shown.
	 */
	@FXML
	private void handleSave() {
		File titleFile = mainApp.getTitleFilePath();
		if (titleFile != null) {
			mainApp.saveTitleDataToFile(titleFile);
			initRecentlyUsedMenu();
		} else {
			handleSaveAs();
		}
	}

	/**
	 * Opens a FileChooser to let the user select a file to save to.
	 * @return 
	 */
	@FXML
	private boolean handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Json files (*.json)", "*.json");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".json")) {
				file = new File(file.getPath() + ".json");
			}
			mainApp.saveTitleDataToFile(file);
			initRecentlyUsedMenu();
			return true;
		}
		return false;
	}

	/**
	 * Opens an about dialog.
	 */
	@FXML
	private void handleAbout() {
		mainApp.showAbout();
	}

	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		if(mainApp.unsavedChangesDetected()) {
			ButtonData buttonPressed = showUnsavedChangesDialog();
			if(buttonPressed == ButtonData.CANCEL_CLOSE)
				return;
		}
		System.exit(0);
	}
	
	public ButtonData showUnsavedChangesDialog() {
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("Save");
		String titleFilePath = mainApp.getTitleFilePath() != null ? mainApp.getTitleFilePath().getAbsolutePath() : "untitled"; 
		dialog.setHeaderText("Save file \"" + titleFilePath + "\" ?");
		ButtonType buttonTypeYes = new ButtonType("Yes", ButtonData.YES);
		ButtonType buttonTypeNo = new ButtonType("No", ButtonData.NO);
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().addAll(buttonTypeNo, buttonTypeYes, buttonTypeCancel);

		Optional<ButtonType> btnPressed = dialog.showAndWait();
		if (btnPressed.get().getButtonData() == ButtonData.YES) {
			if(mainApp.getTitleFilePath() != null)
				mainApp.saveTitleDataToCurrentFile();
			else {
				boolean fileSuccesfullySaved = handleSaveAs() ;
				if(!fileSuccesfullySaved)
					return ButtonData.CANCEL_CLOSE;
			}
		}
		return btnPressed.get().getButtonData();
	}
}