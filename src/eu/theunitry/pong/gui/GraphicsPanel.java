package eu.theunitry.pong.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import eu.theunitry.pong.game.Ball;
import eu.theunitry.pong.timer.GameTimer;

public class GraphicsPanel extends JPanel implements ActionListener
{
	public Timer timer;
	public Ball ball;
	
	public GraphicsPanel(JFrame frame)
	{
		this.setBackground(Color.white);
		this.ball = new Ball(frame, 5, 5, 1, 1, 200);

		new GameTimer(this);

	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.drawBall(g);
	}
	
	public void drawBall(Graphics g)
	{
		ball.paintComponent(g);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.updateBall();
		this.repaint();
	}
	
	public void updateBall()
	{
		this.ball.update();
	}
}
