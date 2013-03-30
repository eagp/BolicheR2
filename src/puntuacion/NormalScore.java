package puntuacion;

public final class NormalScore extends TwoShotScore
{

	public NormalScore(int s1, int s2) throws IllegalStateException 
	{
		super(s1, s2);
	}

	public String toString()
	{
		if(this.isStrike())
			return " | X";
		else if(this.isSpare())
			return this.getFirstScore() + " | /";
		else 
			return this.getFirstScore() + " | " + this.getSecondScore(); 
	}

}
