package ass2;


import ass2.models.Commands;
import ass2.models.LoggerDisplay;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ControllerFX {

	private Commands commandHandler = new Commands();

    @FXML private TextField commandLine;
    @FXML private ListView loggerDisplay = new ListView();
    @FXML private TextArea trainsDisplay;
    @FXML private TextArea commandInputDisplay;
    private int trainCounter;

    private List<String> list = new ArrayList<>();
    private ObservableList<String> observableList = FXCollections.observableList(list);


    @FXML
    public void executeCommand(){
		commandHandler.parse(commandLine.getText());
//		commandInputDisplay.setText("heyho");
        trainCounter += 1;
        trainsDisplay.setText("Een treintje erbij: " + trainCounter);
        addLog(commandLine.getText());
    }

    @FXML
    public void addLog(String command){
        observableList.add(command);
        loggerDisplay.setItems(observableList);
    }
}
