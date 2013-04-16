package ventana;

import input.BowlingFileReader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

import puntuacion.Score;

public class BowlingFrameWindow extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private ArrayList<JTextArea> testList1 = new ArrayList<JTextArea>();
	private ArrayList<JTextArea> testList2 = new ArrayList<JTextArea>();
	private ArrayList<Score> score1 = new ArrayList<Score>();
	private ArrayList<Score> score2 = new ArrayList<Score>();
	private BowlingFileReader bfr = null;
	private int limit = 0;
	
	private JTextField field;
	private JButton browse;
	private JButton next;
	private JButton back;
	private JButton start;

	public BowlingFrameWindow() 
	{
		super("Bowling");
		
		this.setSize(690,300);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Player 1:");
		label.setSize(80,32);
		label.setLocation(30,100);
		this.add(label);
		
		JLabel label2 = new JLabel("Player 2:");
		label2.setSize(80,32);
		label2.setLocation(30,170);
		this.add(label2);
		
		this.field = new JTextField();
		this.field.setSize(400,32);
		this.field.setLocation(30,20);
		this.add(this.field);
		
		this.browse = new JButton("Browse");
		this.browse.setSize(90,32);
		this.browse.setLocation(450, 20);
		this.browse.setActionCommand("BROWSE");
		this.browse.addActionListener(this);
		this.add(this.browse);
		
		this.start = new JButton("Start");
		this.start.setSize(90,32);
		this.start.setLocation(550, 20);
		this.start.setActionCommand("START");
		this.start.addActionListener(this);
		this.add(this.start);
		
		this.back = new JButton("Back");
		this.back.setSize(90,32);
		this.back.setLocation(30, 230);
		this.back.setActionCommand("BACK");
		this.back.addActionListener(this);
		this.add(this.back);
		
		this.next = new JButton("Next");
		this.next.setSize(90,32);
		this.next.setLocation(140, 230);
		this.next.setActionCommand("NEXT");
		this.next.addActionListener(this);
		this.add(this.next);
		
		this.back.setEnabled(false);
		this.next.setEnabled(false);
		this.setVisible(true);
	}
	
	private void addText()
	{
		for(int i = 0; i <  this.score1.size(); i++)
		{
			JTextArea tempText = new JTextArea();
			tempText.setSize(i == 9 ? 58 : 32,32);
			//tempText.setText(this.score1.get(i).toString()+String.format("\n%d",this.score1.get(i).getTotal()));
			tempText.setLocation(120+i*50, 110);
			tempText.setEditable(false);
			testList1.add(tempText);
		}
		
		for(JTextArea text : testList1)
			this.add(text);
		
		for(int i = 0; i < this.score2.size(); i++)
		{
			JTextArea tempText = new JTextArea();
			tempText.setSize(i == 9 ? 58 : 32,32);
			//tempText.setText(this.score2.get(i).toString()+String.format("\n%d",this.score2.get(i).getTotal()));
			tempText.setLocation(120+i*50, 180);
			tempText.setEditable(false);
			testList2.add(tempText);
		}
		
		for(JTextArea text : testList2)
			this.add(text);
		
		this.repaint();
	}
	
	private void deleteScore()
	{
		for(JTextArea temp1:this.testList1)
			this.remove(temp1);
		for(JTextArea temp2:this.testList2)
			this.remove(temp2);
		
		this.testList1.clear();
		this.testList2.clear();
		
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "BROWSE")
		{
			JFileChooser fs = new JFileChooser();
			int val = fs.showOpenDialog(this);
			if(val == JFileChooser.APPROVE_OPTION)
				this.field.setText(fs.getSelectedFile().toString());
			this.next.setEnabled(false);
			this.back.setEnabled(false);
		}
		
		if(e.getActionCommand() == "START")
		{
			this.deleteScore();
			this.limit = 0;
			this.score1.clear();
			this.score2.clear();
			this.back.setEnabled(false);
			this.next.setEnabled(false);
			
			try
			{
				this.bfr = new BowlingFileReader(new File(this.field.getText()));
				ScoreFrame sf = new ScoreFrame(bfr);
				this.score1 = sf.getPlayerOneScore();
				this.score2 = sf.getPlayerTwoScore();
				this.next.setEnabled(true);
				this.addText();
			}
			catch(IllegalStateException err)
			{
				JOptionPane.showMessageDialog(this, err.getLocalizedMessage());
			}
		}
		if(e.getActionCommand() == "BACK")
		{
			this.next.setEnabled(true);
			this.limit--;
			if(this.limit == 0)
			{
				this.back.setEnabled(false);
			}
			
			this.testList1.get(this.limit).setText("");
			if(this.testList2.size() == this.testList1.size() || this.limit < this.score2.size())
				this.testList2.get(this.limit).setText("");		
		}
		if(e.getActionCommand() == "NEXT")
		{
			this.back.setEnabled(true);
			if(limit == this.score1.size()-1)
				this.next.setEnabled(false);
			this.testList1.get(this.limit).setText(this.score1.get(this.limit).toString() 
					+ "\n" + this.score1.get(this.limit).getTotal());
			if(this.testList2.size() == this.testList1.size() || this.limit < this.score2.size())
				this.testList2.get(this.limit).setText(this.score2.get(this.limit).toString() 
						+ "\n" + this.score2.get(this.limit).getTotal());
			this.limit++;
		}
	}
}
