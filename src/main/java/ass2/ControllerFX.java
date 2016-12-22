package ass2;

import ass2.models.Commands;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFX implements Initializable{

	private Commands commandHandler = new Commands();

	@FXML private TextArea logdisplay = new TextArea();
	@FXML private TextArea outputdisplay;
    @FXML private TextField commandLine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logdisplay.setText("hai");
    }

    @FXML
    public void executeCommand(){
		commandHandler.parse(commandLine.getText());
    }

    @FXML
    public void updateLog(String log){
        logdisplay.setText(log);
    }


}
