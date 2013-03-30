package puntuacion;

public interface Score 
{
	/*Interface identica a la de la primera edicion del programa de boliche.
	 * Se le pide al programador que use esta interface para guiarse en que es lo
	 * esencial para una puntuacion de boliche. Se mantienen los mismos comentarios
	 * hechos en la edicion anterior ya que los metodos deben comportarse de
	 * la misma manera. 
	 * */
	public int getTotal();
	public int getFirstScore(); 
	public int getSecondScore();
	public boolean isStrike();
	public boolean isSpare(); 
	public int getThirdScore();
	public boolean isFirstStrike();
	public boolean isFirstSetSpare();
	public boolean isPerfect();
	public void addToTotal(int num);
	public String toString();
}