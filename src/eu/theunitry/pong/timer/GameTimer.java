package eu.theunitry.pong.timer;

import javax.swing.Timer;

import eu.theunitry.pong.gui.GraphicsPanel;

public class GameTimer
{
	public Timer timer;
	public GraphicsPanel graphicsPanel;
	public static final int TICK = 5;
	
	public GameTimer(GraphicsPanel panel)
	{
		this.graphicsPanel = panel;
		this.timer = new Timer(TICK, graphicsPanel);
		this.timer.start();
	}
	
	
}
