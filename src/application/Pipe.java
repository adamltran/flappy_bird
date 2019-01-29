package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pipe extends Group {
	private double x;
	private double y;
//	private static double pipeHeightScale = 0.9;
	private static double topx = 75;
	private static double topy = topx*.4;
	private static double bottomx = 2*topx/3;
	private static double bottomy = bottomx*4;
	private double pipeSpeed = 4;
	protected static double pipeHeight = topy + bottomy;
	protected static double pipeWidth = topx;
	protected static final double pipeXSpace = Bird.size*3.7  + Pipe.pipeWidth;
	protected static final double pipeYSpace = Bird.size*3.5 + 2*topy;
	protected double topPipeBounds;
	protected double bottomPipeBounds;
	double randomHeight = -Math.random()*(Game.height - pipeHeight*1.5) + pipeHeight*.75;
	double topPipeBodyLength = Game.height + randomHeight - pipeHeight;
	protected Rectangle r1 = new Rectangle(topx, topy, Color.LAWNGREEN);
	protected Rectangle r2 = new Rectangle(bottomx, Game.height/3 - randomHeight, Color.LAWNGREEN);
	protected Rectangle r3 = new Rectangle(topx, topy, Color.LAWNGREEN);
	protected Rectangle r4 = new Rectangle(bottomx, topPipeBodyLength, Color.LAWNGREEN);
	
	public Pipe(double x, double y){
		this.x = x;
		this.y = y;
//		double randomHeight = Math.random()*bottomx*4 - pipeHeight*.25;
		
		r1.setStroke(Color.BLACK);
		r1.setStrokeWidth(2);
		r1.setTranslateY(randomHeight);
		r2.setStroke(Color.BLACK);
		r2.setStrokeWidth(2);
		r2.setTranslateX(r1.getTranslateX() + (topx-bottomx)/2);
		r2.setTranslateY(r1.getTranslateY() + topy);

		
		
		r3.setStroke(Color.BLACK);
		r3.setStrokeWidth(2);
		r3.setTranslateX(0);
		r3.setTranslateY(r1.getTranslateY() - pipeYSpace);
		r4.setStroke(Color.BLACK);
		r4.setStrokeWidth(2);
		r4.setTranslateX(r3.getTranslateX() + (topx-bottomx)/2);
		r4.setTranslateY(r3.getTranslateY() - topPipeBodyLength);

		this.getChildren().add(r1);
		this.getChildren().add(r2);
		this.getChildren().add(r3);
		this.getChildren().add(r4);
	}

	public void update() {

		this.setTranslateX(this.getTranslateX() - pipeSpeed);
		this.setTranslateY(y);
	}
}
