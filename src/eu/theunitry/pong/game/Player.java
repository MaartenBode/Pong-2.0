package eu.theunitry.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player {

	private Color color;
	private double x, y;
	private int width, height;
	private Rectangle hitbox;
	
	public Player(double x) {
		this.x = x;
		y = 250;
		width = 10;
		height = 100;
		color = new Color(100, 100, 100);
		hitbox = new Rectangle((int) x, (int) y, width, height);
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			y--;
		}

		hitbox.move((int) x, (int) y);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRoundRect((int) x, (int) y, width, height, 10, 10);
	}
	
}
