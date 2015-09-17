package eu.theunitry.pong.gui;

import javax.swing.JFrame;

public class Frame
{
	public JFrame frame;
	public GraphicsPanel graphicsPanel;
	
	private static final String NAME = "Pong 2.0";
	public static final int HEIGHT = 500;
	public static final int WIDTH = 700;
	
	
	public Frame()
	{
		frame = new JFrame();
		graphicsPanel = new GraphicsPanel(this);
		
		this.init();
		frame.add(graphicsPanel);
		frame.setVisible(true);
	}
	
	public void init()
	{
		frame.setTitle(NAME);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
	
}
