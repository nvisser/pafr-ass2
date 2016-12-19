package ass2;


import ass2.models.Commands;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerFX {

	private Commands commandHandler = new Commands();

    @FXML private TextField commandLine;
    @FXML private TextArea loggerDisplay;
    @FXML private TextArea trainsDisplay;
    @FXML private TextArea commandInputDisplay;
    private int trainCounter;

    @FXML
    public void executeCommand(){
        loggerDisplay.setText(commandLine.getText());
		commandHandler.parse(commandLine.getText());
		commandInputDisplay.setText("heyho");
        trainCounter += 1;
        trainsDisplay.setText("Een treintje erbij: " + trainCounter);


    }
}
