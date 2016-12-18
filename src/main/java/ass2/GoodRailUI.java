package ass2;

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

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception
	{
		window.setTitle("Hello World");

		final TextField commandInput = new TextField();
		commandInput.setPromptText("Typ je command");

		button = new Button("Click 4 fun");
		button.setOnAction(e -> printCommand(commandInput));

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(commandInput, button);

		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	private void printCommand(TextField input)
	{
		System.out.println(input.getText());
	}
}

