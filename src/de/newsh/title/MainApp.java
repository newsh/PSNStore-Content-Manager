package de.newsh.title;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import de.newsh.title.model.Title;
import de.newsh.title.model.TitleListWrapper;
import de.newsh.title.view.RootLayoutController;
import de.newsh.title.view.TitleEditDialogController;
import de.newsh.title.view.TitleOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Title> titleData = FXCollections.observableArrayList();
    public MainApp() {
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PSN Content Manager");
        this.primaryStage.getIcons().add(new Image("file:resources/images/iconfinder_playstation_287542.png"));
        
        initRootLayout();

        showTitleOverview();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
         // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
     // Try to load last opened person file.
        File file = getTitleFilePath();
        if (file != null) {
            loadTitleDataFromFile(file);
        }
    }

    /**
     * Shows the title overview inside the root layout.
     */
    public void showTitleOverview() {
        try {
        	// Load person overview.
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TitleOverview.fxml"));
            AnchorPane titleOverview = (AnchorPane) loader.load();
            // Set person overview into the center of root layout.
            rootLayout.setCenter(titleOverview);
            
         // Give the controller access to the main app.
            TitleOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Opens a dialog to edit details for the specified title. If the user
     * clicks OK, the changes are saved into the provided title object and true
     * is returned.
     * 
     */
    public boolean showTitleEditDialog(Title title) {
    	try {
//        	datePicker.setOnAction(event -> {
//        	    LocalDate date = datePicker.getValue();
//        	    System.out.println("Selected date: " + date);
//        	});
        	// Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TitleEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Title");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setResizable(false);
            Scene scene = new Scene(page);            //dialogStage.setScene(new Scene(root,400,400));
            dialogStage.setScene(scene);

            // Set the title into the controller.
            TitleEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setTitle(title);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ObservableList<Title> getTitleData() {
        return titleData;
    }
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    /**
     * Returns the title file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     * 
     * @return
     */
    public File getTitleFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     * 
     * @param file the file or null to remove the path
     */
    public void setTitleFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());
            // Update the stage title.
            primaryStage.setTitle("PSN Content Manager - " + file.getName());
        } else {
            prefs.remove("filePath");
            // Update the stage title.
            primaryStage.setTitle("PSN Content Manager");
        }
    }
    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     * 
     * @param file
     */
    public void loadTitleDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(TitleListWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE,"application/json");
            //unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
            // Reading XML from the file and unmarshalling.
            TitleListWrapper wrapper = (TitleListWrapper) unmarshaller.unmarshal(file);

            titleData.clear();
            titleData.addAll(wrapper.getTitles());

            // Save the file path to the registry.
            setTitleFilePath(file);

        } catch (Exception e) { // catches ANY exception
            System.out.println(e);
        	Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    /**
     * Saves the current title data to the specified file.
     * 
     * @param file
     */
    public void saveTitleDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(TitleListWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(MarshallerProperties.MEDIA_TYPE,"application/json");
            
            // Set it to true if you need to include the JSON root element in the JSON output
    		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
    		// Set it to true if you need the JSON output to formatted
    		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Wrapping our person data.

    		
    		TitleListWrapper wrapper = new TitleListWrapper();
            wrapper.setTitles(titleData);

            // Marshalling and saving XML to the file.
            marshaller.marshal(wrapper, file);

            // Save the file path to the registry.
            setTitleFilePath(file);
        } catch (Exception e) { // catches ANY exception
            System.out.println(e);
        	Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }
	public void saveTitleDataToCurrentFile() {
		File titleFile = this.getTitleFilePath();
		this.saveTitleDataToFile(titleFile);
	}

    public static void main(String[] args) {
        launch(args);
    }


}