package eu.theunitry.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Objects;

import eu.theunitry.pong.gui.Frame;

public class Player {

	private Color color;
	public double x, y;
	private int width, height;
	private Rectangle hitbox;
	private Ball ball;
	private String position;
	private Frame frame;
	
	public Player(Frame frame, Ball ball, String position) {
		this.frame = frame;
		this.ball = ball;
		this.position = position;
		this.setPosition();
		width = 10;
		height = 100;
		color = new Color(247, 8, 67);
	}
	
	public void setPosition()
	{
		if(this.position == "left")
		{
			this.x = 20;
			this.y = 300;
		}
		if(this.position == "right")
		{
			this.x = 660;
			this.y = 200;
		}
		
	}
	
	public void move(String direction)
	{
		int distance = 20;
		if(Objects.equals(direction, "UP"))
		{
			if (this.y >= distance) this.y -= distance;
		}
		if(Objects.equals(direction, "DOWN"))
		{
			if (this.y <= 360) this.y += distance;
		}
		this.y = Math.max(0, Math.min(this.y, this.frame.frame.getContentPane().getHeight() - this.height));
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect((int) x, (int) y, width, height);
		this.update();
	}
	

	
	public void update()
	{
		hitbox = new Rectangle((int) x, (int) y, width, height);

		if(hitbox.intersects(ball.hitbox))
		{
			if (position == "left" && ball.right ) {
				ball.left = true;
				ball.right = false;
				ball.velx *= -1;
			}
			if (position == "right" && ball.left ) {
				ball.left = false;
				ball.right = true;
				ball.velx *= -1;
			}
		}
	}
	
}
