package test;

import static org.junit.Assert.*;

import input.BowlingFileReader;

import java.io.File;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import puntuacion.Score;
import ventana.ScoreFrame;

public class TestTotalScore 
{
	@Test
	public void testPlayer1Score() 
	{
		ArrayList<Score> score = new ScoreFrame(new BowlingFileReader(new File("src/input/score2.txt"))).getPlayerOneScore();
		assertEquals(40, score.get(2).getTotal());
	}

	@Ignore
	public void testPlayer2Score() 
	{
		ArrayList<Score> score = new ScoreFrame(new BowlingFileReader(new File("src/input/score1.txt"))).getPlayerOneScore();
		assertEquals(12, score.get(0).getTotal());
		assertEquals(32, score.get(1).getTotal());
		assertEquals(49, score.get(2).getTotal());
		assertEquals(56, score.get(3).getTotal());
		assertEquals(73, score.get(4).getTotal());
		assertEquals(87, score.get(5).getTotal());
		assertEquals(95, score.get(6).getTotal());
		assertEquals(104, score.get(7).getTotal());
		assertEquals(124, score.get(8).getTotal());
		assertEquals(145, score.get(9).getTotal());
	}
}
