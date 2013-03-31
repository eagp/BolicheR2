package test;

import static org.junit.Assert.*;

import org.junit.Test;

import puntuacion.tipo_puntuacion.LastScore;


public class TestThreeShotScore 
{

	@Test(expected=IllegalStateException.class)
	public void testScore1() 
	{
		LastScore score = new LastScore(10,10,100);
		score.toString();
	}
	
	@Test(expected=IllegalStateException.class)
	public void testScore2() 
	{
		LastScore score = new LastScore(101,10,0);
		score.toString();
	}

	@Test(expected=IllegalStateException.class)
	public void testScore3() 
	{
		LastScore score = new LastScore(10,190,0);
		score.toString();
	}
	
	@Test
	public void testScore4() 
	{
		LastScore score = new LastScore(10,10,10);
		assertNotNull(score);
	}

	@Test
	public void testGetFirstScore() 
	{
		LastScore score = new LastScore(10,10,10);
		assertEquals(10,score.getFirstScore());
	}
	
	@Test
	public void testGetSecondScore() 
	{
		LastScore score = new LastScore(10,8,10);
		assertEquals(8,score.getSecondScore());
	}
	
	@Test
	public void testIsSpare() 
	{
		LastScore score = new LastScore(2,8,10);
		assertEquals(true,score.isFirstSetSpare());
	}
	
	@Test
	public void testIsNotSpare() 
	{
		LastScore score = new LastScore(10,8,10);
		assertEquals(false,score.isFirstSetSpare());
	}
	
	@Test
	public void testIsPerfect() 
	{
		LastScore score = new LastScore(10,10,10);
		assertEquals(true,score.isPerfect());
	}
	
	@Test
	public void testIsNotPerfect() 
	{
		LastScore score = new LastScore(10,10,9);
		assertEquals(false,score.isPerfect());
	}
	
	@Test
	public void testString() 
	{
		LastScore score = new LastScore(10,10,9);
		assertEquals("X | X | 9", score.toString());
		score = new LastScore(10,10,0);
		assertEquals("X | X | 0", score.toString());
		score = new LastScore(9,1,0);
		assertEquals("9 | / | 0", score.toString());
		score = new LastScore(3,6,10);
		assertEquals("3 | 6", score.toString());
	}
	
	
}
