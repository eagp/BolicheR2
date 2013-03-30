package puntuacion;

public abstract class TwoShotScore implements Score 
{
	protected int score1;
	protected int score2;
	protected int scoreTotal;
	
	public TwoShotScore(int s1, int s2) throws IllegalStateException 
	{

		this.score1 = (s1>=0) ? s1 : 0;
		this.score2 = (s2>=0) ? s2 : 0;
		if(s1+s2>10 || s1 > 10 || s2 > 10)
			throw new IllegalStateException("Numero de puntuacion pasada");

		this.scoreTotal = s1+s2; 
	}
	
	public int getTotal() 
	{
		return this.scoreTotal;
	}

	public int getFirstScore() 
	{
		return this.score1;
	}

	public int getSecondScore() 
	{
		return this.score2;
	}

	public boolean isStrike() 
	{
		return (this.score1 == 10 && this.score2 == 0);
	}

	public boolean isSpare() 
	{
		return (this.score1 + this.score2) == 10 && !this.isStrike();
	}
	
	public void addToTotal(int num) 
	{
		this.scoreTotal += num;
	}
	
	public abstract String toString(); //TO DO: Heredar e implementar
	
	/*Metodos que son inutiles para una puntuacion de dos tiros.
	 * No deben ser heredados
	 * */

	public final int getThirdScore() 
	{
		return 0;
	}

	public final boolean isFirstStrike() 
	{
		return false;
	}

	public final boolean isFirstSetSpare() 
	{
		return false;
	}

	public final boolean isPerfect() 
	{
		return false;
	}
}
