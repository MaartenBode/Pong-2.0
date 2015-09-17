package eu.theunitry.pong.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel
{
	public JLabel player1, player2;
	
	public ScoreBoard()
	{
		player1 = new JLabel("0");
		player2 = new JLabel("0");
		this.setLayout(new BorderLayout());
		this.add(player1, BorderLayout.WEST);
		this.add(player2, BorderLayout.EAST);
		player1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		player2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(500, 60));
	}
}
