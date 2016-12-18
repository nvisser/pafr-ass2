package ass2;

import ass2.models.Commands;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GoodRailUI extends Application
{
	private Scene scene;
	private Button button;
	private Commands commandParser = new Commands();

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception
	{
		window.setTitle("Hello World");

		//Makes the Textfield
		final TextField commandInput = new TextField();
		commandInput.setPromptText("Typ je command");

		//Makes the button and uses the command when pressed
		button = new Button("Click 4 fun");
		button.setOnAction(e -> this.commandParser.parse(commandInput.getText()));

        //Sets VBox
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(commandInput, button);

		//Sets the scene width and height and shows him
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
}

