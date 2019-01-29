package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bird extends Group{
	private double y;
	private double x = Game.width/4;
	private double dy;
	private double ddy = 10;
	public static final double size = 50;
	private boolean flap;
	private boolean flapImpulse;

	public Bird(double x, double y) {
		this.x = x;
		this.y = y;
		Rectangle r = new Rectangle(size, size, Color.YELLOW);

		this.getChildren().add(r);
	}
	
	public void update() {
		x = Game.width/4/Game.scale;
		double t = 1d/60;
		
		if(isFlapImpulse() && y > size/Game.scale/2) {
			
			dy = -2.5;
		}
		y = y + dy*t + .3*ddy*t*t;
		dy = dy + ddy*t;
		
		
		if(y > (Game.height - size)/Game.scale) {
			y = (Game.height - size)/Game.scale;
			dy = 0;	
		}
				
		
		this.setTranslateX(x*Game.scale);

		this.setTranslateY(y*Game.scale);

	}
	
	public boolean collidedWith(Pipe p) {
//		System.out.println(p.r2.getLocalToSceneTransform().getTx());
		if(p.r1.getBoundsInParent().intersects(this.getBoundsInParent()) ||
				p.r2.getBoundsInParent().intersects(this.getBoundsInParent()) ||
				p.r3.getBoundsInParent().intersects(this.getBoundsInParent()) ||
				p.r4.getBoundsInParent().intersects(this.getBoundsInParent())
				) {
			return true;
		}
		return false;
	}
	
	public void flap() {
		if(!flap) {
			flapImpulse = true;
		}
		flap = true;
	}
	
	public void unflap() {
		flap = false;
	}
	
	public boolean isFlapImpulse() {
		if(flapImpulse) {
			flapImpulse = false;
			return true;
		}
		else {
			return false;
		}
	}
}
