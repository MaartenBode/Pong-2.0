package eu.theunitry.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

import eu.theunitry.pong.gui.Frame;

public class Ball {

	private int size;
	public double x, y, velx, vely;
	private int frameHeight, frameWidth;
	private Color color;
	private Frame frame;
	public Rectangle hitbox;
	public boolean left, right;
	
	public Ball(Frame frame, double velx, double vely, int size) {
		this.frame = frame;
		this.size = size;
		this.frameWidth = frame.WIDTH;
		this.frameHeight = frame.HEIGHT;
		this.x = (this.frameWidth / 2) - (this.size / 2);
		this.y = (this.frameHeight / 2) - (this.size / 2);
		this.setPos(this.x, this.y);
		this.setVel(velx, vely);
		this.color = new Color(247, 8, 67);
		this.hitbox = new Rectangle((int) x, (int) y, size, size);
		left = true;
		right = true;
	}
	
	public void update() {
		this.x += this.velx;
		this.y += this.vely;
	
		
		if (y < 0 || y > frame.frame.getContentPane().getHeight() - size) {
			this.vely *= -1;
		}
		this.y = Math.max(0, Math.min(y, frame.frame.getContentPane().getHeight() - size));
		this.hitbox.move((int) x, (int) y);
	}
	
	public void reset()
	{
		this.x = (this.frameWidth / 2) - (this.size / 2);
		this.y = (this.frameHeight / 2) - (this.size / 2);
		this.setPos(this.x, this.y);
		this.setVel(velx, vely);
		this.hitbox = new Rectangle((int) x, (int) y, size, size);
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
		if (x > frame.WIDTH) {
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
