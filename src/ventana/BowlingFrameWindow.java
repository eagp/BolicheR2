package ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class BowlingFrameWindow extends JFrame implements ActionListener 
{
	private ArrayList<JLabel> testList1 = new ArrayList<JLabel>();
	private ArrayList<JTextArea> testList2 = new ArrayList<JTextArea>();
	
	private JTextField field;
	private JButton browse;
	private JButton next;
	private JButton back;
	private JButton start;

	public BowlingFrameWindow() 
	{
		super("Bowling");
		
		this.setSize(650,300);
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
		this.add(this.back);
		
		this.next = new JButton("Next");
		this.next.setSize(90,32);
		this.next.setLocation(140, 230);
		this.next.setActionCommand("NEXT");
		this.add(this.next);
		
		this.repaint();
	}
	
	private void addText()
	{
		for(int i = 0; i <  10; i++)
		{
			JLabel tempText = new JLabel();
			tempText.setSize(48,22);
			//tempText.setEditable(false);
			tempText.setText("   | X");
			tempText.setLocation(120+i*50, 110);
			testList1.add(tempText);
		}
		
		for(JLabel text : testList1)
			this.add(text);
		
		for(int i = 0; i <  10; i++)
		{
			JTextArea tempText = new JTextArea();
			tempText.setSize(48,22);
			tempText.setText("     | X");
			tempText.setEditable(false);
			tempText.setLocation(120+i*50, 180);
			testList2.add(tempText);
		}
		
		for(JTextArea text : testList2)
			this.add(text);
		
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
			this.back.setEnabled(false);
			this.next.setEnabled(false);
		}
	}
}
