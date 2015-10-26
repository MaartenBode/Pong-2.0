package eu.theunitry.pong.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlManager implements KeyListener
{
	
	private Player player1, player2;
	
	public ControlManager(Player player1, Player player2)
	{
		this.player1 = player1;
		this.player2 = player2;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 81) this.player1.move("UP");
		if(e.getKeyCode() == 65) this.player1.move("DOWN");
		
		if(e.getKeyCode() == 79) this.player2.move("UP");
		if(e.getKeyCode() == 76) this.player2.move("DOWN");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 81) this.player1.move("");
		if(e.getKeyCode() == 65) this.player1.move("");
		
		if(e.getKeyCode() == 79) this.player2.move("");
		if(e.getKeyCode() == 76) this.player2.move("");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
