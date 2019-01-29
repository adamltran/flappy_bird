package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Game extends Group {

	public static final double scale = 300;
	public static final double height = 600;
	public static final double width = 600;
	
	
	private Bird b;
	private Pipe p;
	private Rectangle background;
	private boolean gameOver;

	public Game() throws IOException {
		b = new Bird(0, 0);
		ArrayList<Pipe> pipes = new ArrayList<Pipe>();
		for(int i = 0; i < 3; i++) {
			Pipe tmp = new Pipe((Game.width/2), Game.height - Pipe.pipeHeight);
			tmp.setTranslateX(tmp.getTranslateX() + i*Pipe.pipeXSpace + Game.width);
			pipes.add(tmp);
		}
		background = new Rectangle(Game.width, Game.height, Color.CORNFLOWERBLUE);

		this.getChildren().add(background);
		this.getChildren().addAll(pipes);
		this.getChildren().add(b);

		AnimationTimer timer = new AnimationTimer(){
			@Override
			public void handle(long now) {
				if(gameOver) {
					this.stop();
				}
				b.update();
				for(int i = 0; i < pipes.size(); i++) {
					
					if(b.collidedWith(pipes.get(i))) {
						System.out.println("Collided with: " + pipes.get(i));
						gameOver = true;
						
					}
					if(pipes.get(i).getTranslateX() < -Pipe.pipeWidth) {
						removePipe(pipes.get(i));
						pipes.remove(pipes.get(i));

						Pipe tmp = new Pipe((Game.width), Game.height - Pipe.pipeHeight);
						tmp.setTranslateX(Game.width + Pipe.pipeWidth);

						addPipe(tmp);
						pipes.add(tmp);

					}

					pipes.get(i).update();
				}

			}
		};
		timer.start();
	}

	private void addPipe(Pipe p) {
		this.getChildren().add(p);
	}

	private void removePipe(Pipe p) {
		this.getChildren().remove(p);
	}
	public void keyPressHandler(KeyEvent e) {
		if(e.getCode() == KeyCode.SPACE) {
			b.flap();
		}
	}

	public void keyReleasedHandler(KeyEvent e) {
		if(e.getCode() == KeyCode.SPACE) {
			b.unflap();
		}
	}
}

