package ventana;

import input.BowlingFileReader;
import java.util.ArrayList;
import puntuacion.Score;
import puntuacion.tipo_puntuacion.LastScore;
import puntuacion.tipo_puntuacion.NormalScore;

public final class ScoreFrame 
{
	private ArrayList<Score> score1 = new ArrayList<Score>();
	private ArrayList<Score> score2 = new ArrayList<Score>();
	private ArrayList<Integer> player1LineScore; 
	private ArrayList<Integer> player2LineScore;

	public ScoreFrame(BowlingFileReader bf)
	{ 
		player1LineScore = bf.getPlayerOneScore();
		player2LineScore = bf.getPlayerTwoScore();
		
		this.setPlayerOneScore();
		this.completePlayerOneScore();
		
		this.setPlayerTwoScore();
		this.completePlayerTwoScore();
	}
	
	private void setPlayerOneScore()
	{
		if(this.player1LineScore.isEmpty())
			return;
		int limit = this.player1LineScore.size()/2;
		int it = 0;
		for(int i = 0; i<limit && this.player1LineScore.get(it)!=null; i++,it+=2)
		if(i<9)
			this.score1.add(new NormalScore(this.player1LineScore.get(it), this.player1LineScore.get(it+1)));
		else
			this.score1.add(new LastScore(this.player1LineScore.get(it), this.player1LineScore.get(it+1),this.player1LineScore.get(it+2)));
	}
	
	private void completePlayerOneScore()
	{
		int limit = this.score1.size();
		for(int i = 0 ; i < limit && i<9; i++)   
		{
			if(score1.get(i).isStrike() && i+1 < limit)
				if(score1.get(i+1).isStrike() && i+2 < limit)
				{ 
					score1.get(i).addToTotal(10 + score1.get(i+2).getFirstScore());
					if(i>0) 
						score1.get(i).addToTotal(score1.get(i+1).getFirstScore() + score1.get(i+1).getSecondScore());
					continue;
				}
				else
				{
					score1.get(i).addToTotal(score1.get(i+1).getTotal());
					if(i>0) 
						score1.get(i).addToTotal(score1.get(i-1).getTotal());
					continue;
				}
			if(score1.get(i).isSpare() && i + 1 < limit)
			{
				score1.get(i).addToTotal(score1.get(i+1).getFirstScore());
				if(i>0)
					score1.get(i).addToTotal(score1.get(i-1).getTotal());
				continue;
			}
			
			if(i>0) 
				score1.get(i).addToTotal(score1.get(i-1).getTotal());
		}
		if(limit == 10)
			score1.get(9).addToTotal(score1.get(8).getTotal());
	}

	public ArrayList<Score> getPlayerOneScore()
	{
		return this.score1;
	}
	
	
	private void setPlayerTwoScore()
	{
		if(this.player1LineScore.isEmpty())
			return;
		int limit = this.player2LineScore.size()/2;
		int it = 0;
		for(int i = 0; i<limit && this.player2LineScore.get(it)!=null; i++,it+=2)
		if(i<9)
			this.score2.add(new NormalScore(this.player2LineScore.get(it), this.player2LineScore.get(it+1)));
		else
			this.score2.add(new LastScore(this.player2LineScore.get(it), this.player2LineScore.get(it+1),this.player2LineScore.get(it+2)));
	}
	
	private void completePlayerTwoScore()
	{
		int limit = this.score2.size();
		for(int i = 0 ; i < limit && i<9; i++)   
		{
			if(score2.get(i).isStrike() && i+1 < limit)
				if(score2.get(i+1).isStrike() && i+2 < limit)
				{ 
					score2.get(i).addToTotal(10 + score2.get(i+2).getFirstScore());
					if(i>0) 
						score2.get(i).addToTotal(score2.get(i-1).getTotal());
					continue;
				}
				else
				{
					score2.get(i).addToTotal(score2.get(i+1).getFirstScore() + score2.get(i+1).getSecondScore());
					if(i>0) 
						score2.get(i).addToTotal(score2.get(i-1).getTotal());
					continue;
				}
			if(score2.get(i).isSpare() && i + 1 < limit)
			{
				score2.get(i).addToTotal(score2.get(i+1).getFirstScore());
				if(i>0)
					score2.get(i).addToTotal(score2.get(i-1).getTotal());
				continue;
			}
			
			if(i>0) 
				score2.get(i).addToTotal(score2.get(i-1).getTotal());
		}
		
		if(limit == 10)
			score2.get(9).addToTotal(score2.get(8).getTotal());
	}

	public ArrayList<Score> getPlayerTwoScore()
	{
		return this.score2;
	}
}
