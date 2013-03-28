package ventana;

import java.util.ArrayList;

import javax.swing.*;

public class BowlingFrameWindow extends JFrame
{
	private ArrayList<JTextArea> testList1 = new ArrayList<JTextArea>();
	private ArrayList<JTextArea> testList2 = new ArrayList<JTextArea>();

	public BowlingFrameWindow() 
	{
		super("Bowling");
		
		this.setSize(800,400);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.initialize();
		this.addText();
	}
	
	private void initialize()
	{
		JLabel label = new JLabel("Player 1:");
		label.setSize(80,32);
		label.setLocation(30,100);
		this.add(label);
		
		JLabel label2 = new JLabel("Player 2:");
		label2.setSize(80,32);
		label2.setLocation(30,170);
		this.add(label2);
		
		this.repaint();
	}
	
	private void addText()
	{
		for(int i = 0; i <  10; i++)
		{
			JTextArea tempText = new JTextArea();
			tempText.setSize(48,48);
			tempText.setEditable(false);
			tempText.setLocation(120+i*50, 100);
			testList1.add(tempText);
		}
		
		for(JTextArea text : testList1)
			this.add(text);
		
		for(int i = 0; i <  10; i++)
		{
			JTextArea tempText = new JTextArea();
			tempText.setSize(48,48);
			tempText.setEditable(false);
			tempText.setLocation(120+i*50, 170);
			testList2.add(tempText);
		}
		
		for(JTextArea text : testList2)
			this.add(text);
		
		this.repaint();
	}
}
