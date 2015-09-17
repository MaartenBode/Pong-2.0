package eu.theunitry.pong.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import eu.theunitry.pong.timer.GameTimer;

public class GraphicsPanel implements ActionListener
{
	public JPanel panel;
	public Timer timer;
	
	public GraphicsPanel()
	{
		panel = new JPanel();
		panel.setBackground(Color.black);
		
		new GameTimer(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("tes");
		panel.repaint();
	}

}
