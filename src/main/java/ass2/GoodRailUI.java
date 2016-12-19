package ass2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	public void start(Stage window) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/GoodRail.fxml"));
        window.setTitle("Thomas de Trein");

		//Sets the scene width and height and shows him
		Scene scene = new Scene(root, 600, 400);
		window.setScene(scene);
		window.show();
	}
}

