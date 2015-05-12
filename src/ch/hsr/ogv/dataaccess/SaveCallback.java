package ch.hsr.ogv.dataaccess;

import java.io.File;

import javafx.stage.Stage;
import ch.hsr.ogv.view.MessageBar;
import ch.hsr.ogv.view.MessageBar.MessageLevel;

/**
 * 
 * @author Simon Gwerder
 *
 */
public class SaveCallback implements PersistencyCallback {
	
	private Stage primaryStage;
	private String appTitle;
	private File file;
	
	public SaveCallback(Stage primaryStage, String appTitle, File file) {
		this.primaryStage = primaryStage;
		this.appTitle = appTitle;
		this.file = file;
	}

	@Override
	public void completed(boolean success) {
		if (success) {
			this.primaryStage.setTitle(this.appTitle + " - " + file.getName()); // set new app title
			MessageBar.setText("Saved file: \"" + file.getPath() + "\".", MessageLevel.INFO);
		} else {
			MessageBar.setText("Could not save data to file: \"" + file.getPath() + "\".", MessageLevel.ALERT);
		}
	}
}
