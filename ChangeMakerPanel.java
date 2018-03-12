/* 
*
*
* Description: The purpose of this GUI program is to allow the user to easily enter a dollar 
			   and cents amount and have the program return the least amount of dollars and 
			   cents needed to reach the amount entered.
*
*
*/




package bank;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

public class ChangeMakerPanel extends JPanel {

	// declare GUI components as needed.    
	JPanel panel;
	JLabel labelOne;
	JLabel labelTwo;
	JLabel labelThree;
	JLabel labelFour;
	JLabel labelFive;
	JLabel labelSix;
	JLabel labelSeven;
	JLabel labelEight;
	JLabel labelNine;
	JLabel labelTen;
	JLabel labelEleven;
	JLabel labelTwelve;
	JTextField textFieldOne;
	JTextField textFieldTwo;
	JButton buttonOne;
	
	final int FRAME_WIDTH = 100;
	final int FRAME_HEIGHT = 100;
	
	public ChangeMakerPanel () {   
		createComponents();   
		createPanel();   
		setSize(FRAME_WIDTH, FRAME_HEIGHT);  
	}   
	
	
	private void createPanel() {   
		panel = new JPanel();   
		panel.setLayout(new GridLayout (15,1));
		
		// add components in order needed   
		
		panel.add(labelOne);
		panel.add(labelTwo);
		panel.add(labelThree);
		panel.add(textFieldOne);
		panel.add(labelFour);
		panel.add(textFieldTwo);
		panel.add(buttonOne);
		panel.add(labelFive);
		panel.add(labelSix);
		panel.add(labelSeven);
		panel.add(labelEight);
		panel.add(labelNine);
		panel.add(labelTen);
		panel.add(labelEleven);
		panel.add(labelTwelve);
		add(panel);
				
	}    
	
	
	private void createComponents() {  
		// create and initialize all components needed 
		labelOne = new JLabel("Enter the dollars and cents amounts");
		labelTwo = new JLabel("Then press \"Make Change\"" );
		labelThree = new JLabel("Dollars");
		textFieldOne = new JTextField(10);
		labelFour = new JLabel("Cents");
		textFieldTwo = new JTextField(10);
		buttonOne = new JButton("Make Change");
		ButtonListener listener = new ButtonListener();
		buttonOne.addActionListener(listener);
		labelFive = new JLabel("Fives: ");
		labelSix = new JLabel("Ones: ");
		labelSeven = new JLabel("Quarters: ");
		labelEight = new JLabel("Dimes: ");
		labelNine = new JLabel("Nickels: "); 
		labelTen = new JLabel("Pennies");
		labelEleven = new JLabel("");
		labelTwelve = new JLabel("Justin Clark");
	}    
	
	
	private class ButtonListener implements ActionListener {   
		public void actionPerformed (ActionEvent event) { 
			int dollars; 
			int cents;
			if (event.getSource() == buttonOne){
				dollars = Integer.parseInt(textFieldOne.getText());
				cents = Integer.parseInt(textFieldTwo.getText());
				Change changeClass = new Change(dollars, cents);
				changeClass.makeChange();
				labelFive.setText("Fives: " + changeClass.getFives());
				labelSix.setText("Ones: " + changeClass.getSingles());
				labelSeven.setText("Quarters: " + changeClass.getQuarters());
				labelEight.setText("Dimes: " + changeClass.getDimes());
				labelNine.setText("Nickels: " + changeClass.getNickels());
				labelTen.setText("Pennies: " + changeClass.getPennies());
				
			}  
		}
	}
	
} // class

