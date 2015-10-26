package eu.theunitry.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Objects;

import eu.theunitry.pong.gui.Frame;

public class Player {

	private Color color;
	public double x, y, vely;
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
		int distance = 2;
		if(Objects.equals(direction, "UP"))
		{
			this.vely = -distance;
		}
		else if (Objects.equals(direction, "DOWN"))
		{
			this.vely = distance;
		} else
		{
			this.vely = 0;
		}
	}
	
	public void reset()
	{
		this.setPosition();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect((int) x, (int) y, width, height);
		this.update();
	}
	

	
	public void update()
	{
		this.y += this.vely;
		this.y = Math.max(0, Math.min(this.y, this.frame.frame.getContentPane().getHeight() - this.height));
		hitbox = new Rectangle((int) x, (int) y, width, height);

		if(hitbox.intersects(ball.hitbox))
		{
			if (position == "left" && ball.right ) {
				ball.left = true;
				ball.right = false;
				ball.velx *= -1;
				ball.setVel(ball.getVelX() * 1.1, ball.getVelY() * 1.1);
				if (ball.y + ball.getSize() / 2 < this.y + height / 2) {
					ball.vely = -Math.abs(ball.vely);
				} else {
					ball.vely = Math.abs(ball.vely);
				}
			}
			if (position == "right" && ball.left ) {
				ball.left = false;
				ball.right = true;
				ball.velx *= -1;
				ball.setVel(ball.getVelX() * 1.1, ball.getVelY() * 1.1);
				if (ball.y + ball.getSize() / 2 < this.y + height / 2) {
					ball.vely = -Math.abs(ball.vely);
				} else {
					ball.vely = Math.abs(ball.vely);
				}
			}
		}
		
		if (ball.scoredLeft() || ball.scoredRight())
		{
			this.setPosition();
			ball.reset();
		}
	}
	
	public void setVelY(double vely)
	{
		this.vely = y;
	}
	
	public double getVelY()
	{
		return vely;
	}
	
}
