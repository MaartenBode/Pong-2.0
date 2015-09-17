package eu.theunitry.pong.game;

import eu.theunitry.pong.gui.ScoreBoard;

public class ScoreBoardListener
{
	private int score1;
	private int score2;
	
	public ScoreBoardListener(ScoreBoard scoreboard, Ball ball)
	{
		if(ball.scoredRight())
		{
			score1++;
			scoreboard.player1.setText(Integer.toString(score1));
		}
		if(ball.scoredLeft())
		{
			score2++;
			scoreboard.player2.setText(Integer.toString(score2));
		}
	}
}
