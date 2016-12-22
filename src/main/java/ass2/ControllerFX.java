package ass2;

import ass2.models.Commands;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerFX {

	private Commands commandHandler = new Commands();

	@FXML private TextArea logdisplay;
	@FXML private TextArea outputdisplay;
    @FXML private TextField commandLine;

    @FXML
    public void executeCommand(){
		commandHandler.parse(commandLine.getText());
    }

}
