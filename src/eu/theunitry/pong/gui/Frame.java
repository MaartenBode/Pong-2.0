package eu.theunitry.pong.gui;

import javax.swing.JFrame;

public class Frame
{
	public JFrame frame;
	
	private static final String NAME = "Pong 2.0";
	private static final int HEIGHT = 500;
	private static final int WIDTH = 700;
	
	
	public Frame()
	{
		frame = new JFrame();
		this.init();
	}
	
	public void init()
	{
		frame.setTitle(NAME);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
