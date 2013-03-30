package test;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

import puntuacion.LastScore;
import puntuacion.NormalScore;
import input.BowlingFileReader;

public class TestInput1
{

	@Test
	public void testScoreFile() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
	}
	
	@Test
	public void testScoreSize1() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
		assertEquals(21, bfr.getPlayerOneScore().size());
	}
	
	@Test
	public void testScoreSize2() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
		assertEquals(21, bfr.getPlayerTwoScore().size());
	}
	
	@Test
	public void testScoreIsSpare1() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
		NormalScore score = new NormalScore(bfr.getPlayerOneScore().get(0), bfr.getPlayerOneScore().get(1));
		assertEquals(false, score.isSpare());
	}
	
	@Test
	public void testScoreIsStrike1() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
		NormalScore score = new NormalScore(bfr.getPlayerOneScore().get(0), bfr.getPlayerOneScore().get(1));
		assertEquals(true, score.isStrike());
	}
	
	@Test
	public void testScoreString1() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
		NormalScore score = new NormalScore(bfr.getPlayerOneScore().get(0), bfr.getPlayerOneScore().get(1));
		assertEquals(" | X", score.toString());
	}
	
	@Test
	public void testScoreIsSpare2() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
		NormalScore score = new NormalScore(bfr.getPlayerTwoScore().get(0), bfr.getPlayerTwoScore().get(1));
		assertEquals(true, score.isSpare());
	}
	
	@Test
	public void testScoreIsStrike2() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
		NormalScore score = new NormalScore(bfr.getPlayerTwoScore().get(0), bfr.getPlayerTwoScore().get(1));
		assertEquals(false, score.isStrike());
	}
	
	@Test
	public void testScoreString2() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
		NormalScore score = new NormalScore(bfr.getPlayerTwoScore().get(0), bfr.getPlayerTwoScore().get(1));
		assertEquals("2 | /", score.toString());
	}
	
	@Test
	public void testScoreFinal1() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
		LastScore score = new LastScore(bfr.getPlayerOneScore().get(18), bfr.getPlayerOneScore().get(19),bfr.getPlayerOneScore().get(20));
		assertEquals(true,score.isPerfect());
	}
	
	@Test
	public void testScoreFinal2() 
	{
		BowlingFileReader bfr = new BowlingFileReader(new File("src/input/score1.txt"));
		LastScore score = new LastScore(bfr.getPlayerTwoScore().get(18), bfr.getPlayerTwoScore().get(19),bfr.getPlayerTwoScore().get(20));
		assertEquals(false,score.isPerfect());
		assertEquals(1,score.getThirdScore());
	}
}
