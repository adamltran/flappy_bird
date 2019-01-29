package application;
	
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
//		BufferedImage image = ImageIO.read(new File("/resources/IMG_6401.png"));
		
		try {
			Game root = new Game();
			Scene scene = new Scene(root, Game.width, Game.height);
			scene.setOnKeyPressed(e->root.keyPressHandler(e));
			scene.setOnKeyReleased(e->root.keyReleasedHandler(e));
			primaryStage.setScene(scene);
			primaryStage.setTitle("Flappy Bird");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
