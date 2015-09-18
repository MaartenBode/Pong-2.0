package eu.theunitry.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player {

	private Color color;
	public double x, y;
	private int width, height;
	private Rectangle hitbox;
	private Ball ball;
	private String position;
	
	public Player(Ball ball, String position) {
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
		if(direction == "UP")
		{
			this.y -= distance;
		}
		if(direction == "DOWN")
		{
			this.y += distance;
		}
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
			ball.velx *= -1;
			ball.velx+= 0.1;
			ball.vely+= 0.1;
		}
	}
	
}
