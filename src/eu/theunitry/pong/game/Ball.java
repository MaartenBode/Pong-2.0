package eu.theunitry.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Ball {

	private int size;
	private double x, y, velx, vely;
	private Color color;
	private JFrame frame;
	private Rectangle hitbox;
	
	public Ball(JFrame frame, double x, double y, double velx, double vely, int size) {
		this.frame = frame;
		this.setPos(x, y);
		this.setVel(velx, vely);
		this.size = size;
		this.color = new Color(247, 8, 67);
		this.hitbox = new Rectangle((int) x, (int) y, size, size);
	}
	
	public void update() {
		this.x += this.velx;
		this.y += this.vely;
		if (y < 0 || y > frame.getContentPane().getHeight() - size) {
			this.vely *= -1;
		}
		this.y = Math.max(0, Math.min(y, frame.getContentPane().getHeight() - size));
		this.hitbox.move((int) x, (int) y);
	}
	
	public void setPos(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setVel(double velx, double vely) {
		this.velx = velx;
		this.vely = vely;
	}
	
	public boolean scoredLeft() {
		if (x < -size) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean scoredRight() {
		if (x > frame.getContentPane().getWidth()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillOval((int) x, (int) y, size, size);
	}
	
}
