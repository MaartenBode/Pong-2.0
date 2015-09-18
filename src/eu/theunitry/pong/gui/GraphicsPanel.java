package eu.theunitry.pong.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import eu.theunitry.pong.game.Ball;
import eu.theunitry.pong.game.ControlManager;
import eu.theunitry.pong.game.Player;
import eu.theunitry.pong.game.ScoreBoardListener;
import eu.theunitry.pong.timer.GameTimer;

public class GraphicsPanel extends JPanel implements ActionListener
{
	public Timer timer;
	public Ball ball;
	public Frame frame;
	public ScoreBoard scoreboard;
	public Player player1, player2;
	
	public GraphicsPanel(Frame frame)
	{
		this.setBackground(Color.white);
		this.scoreboard = new ScoreBoard();
		
		this.frame = frame;
		this.setFocusable(true);
		this.add(this.scoreboard, BorderLayout.NORTH);

		new GameTimer(this);
		
		this.ball = new Ball(this.frame, -1, 1, 50);
		this.player1 = new Player(this.ball, "left");
		this.player2 = new Player(this.ball, "right");
		
		this.addKeyListener(new ControlManager(player1, player2));

		

	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.drawBall(g);
		this.player1.paintComponent(g);
		this.player2.paintComponent(g);
	}
	
	public void drawBall(Graphics g)
	{
		ball.paintComponent(g);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.updateBall();
		new ScoreBoardListener(scoreboard, ball);

		this.repaint();
		
	}
	
	public void updateBall()
	{
		this.ball.update();
	}
}
