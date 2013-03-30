package test;

import static org.junit.Assert.*;

import org.junit.Test;

import puntuacion.NormalScore;

public class TestTwoShotScore {

	@Test(expected=IllegalStateException.class)
	public void testScore() throws IllegalStateException
	{
		NormalScore score = new NormalScore(7, 5);
		score.toString();
	}
	
	@Test
	public void testGetTotalScore()
	{
		NormalScore score = new NormalScore(3, 5);
		assertEquals(8, score.getTotal());
	}
	
	@Test
	public void testGetScoreOne()
	{
		NormalScore score = new NormalScore(3, 5);
		assertEquals(3, score.getFirstScore());
	}
	
	@Test
	public void testGetScoreTwo()
	{
		NormalScore score = new NormalScore(3, 5);
		assertEquals(5, score.getSecondScore());
	}
	
	@Test
	public void testIsStrike()
	{
		NormalScore score = new NormalScore(10, 0);
		assertEquals(true,score.isStrike());
	}
	
	@Test
	public void testIsNotStrike()
	{
		NormalScore score = new NormalScore(9, 0);
		assertEquals(false,score.isStrike());
	}
	
	@Test
	public void testIsSpare()
	{
		NormalScore score = new NormalScore(9, 1);
		assertEquals(true,score.isSpare());
	}
	
	@Test
	public void testIsNotSpare1()
	{
		NormalScore score = new NormalScore(10, 0);
		assertEquals(false,score.isSpare());
	}
	
	@Test
	public void testIsNotSpare2()
	{
		NormalScore score = new NormalScore(5, 4);
		assertEquals(false,score.isSpare());
	}
	
	@Test
	public void testAddToTotal()
	{
		NormalScore score = new NormalScore(5, 5);
		score.addToTotal(10);
		assertEquals(20,score.getTotal());
	}
	
	@Test
	public void testStrikeString()
	{
		NormalScore score = new NormalScore(10, 0);
		assertEquals(" | X",score.toString());
	}
	
	@Test
	public void testSpareString()
	{
		NormalScore score = new NormalScore(9, 1);
		assertEquals("9 | /",score.toString());
	}

	@Test
	public void testString()
	{
		NormalScore score = new NormalScore(6, 3);
		assertEquals("6 | 3",score.toString());
	}

}
