package de.newsh.title.view;

import de.newsh.title.MainApp;

import java.io.File;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Marco Jakob
 */
public class RootLayoutController {

	// Reference to the main application
	private MainApp mainApp;
	@FXML
	Menu recentlyUsedMenu;

	@FXML
	private void initialize() {
		initRecentlyUsedMenu();
	}

	@FXML
	private void initRecentlyUsedMenu() {
		String lastOpendedFiles = Preferences.userNodeForPackage(MainApp.class).get("lastOpenedFiles", null);
		recentlyUsedMenu.getItems().clear();
		for (String path : lastOpendedFiles.split(" ")) {
			MenuItem menuItem = new MenuItem(path);
			menuItem.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					mainApp.loadTitleDataFromFile(new File(menuItem.getText()));
				}
			});
			recentlyUsedMenu.getItems().add(menuItem);
		}

	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Creates an empty address book.
	 */
	@FXML
	private void handleNew() {
		mainApp.getTitleData().clear();
		mainApp.setTitleFilePath(null);
	}

	/**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		if (file != null) {
			mainApp.loadTitleDataFromFile(file);
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
	 */
	@FXML
	private void handleSaveAs() {
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
		}
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
		System.exit(0);
	}
}