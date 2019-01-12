package de.newsh.title.view;

import java.io.IOException;
import de.newsh.title.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class AboutController {

	private MainApp mainApp;
	@FXML
	Hyperlink hyperlink;
	private Stage dialogStage;

	@FXML
	private void openLink() throws IOException {
		mainApp.getHostServices().showDocument(hyperlink.getText());
	}

	@FXML
	private void handleCloseButton() {
		dialogStage.close();
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
