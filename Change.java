package bank;

/* 
* 
*
* Description: This is the logic that the ChangeMakerPanel uses. This program calculates the way to make change using the least amount of dollars and cents.
*
*
*/ 

public class Change extends Money {

	private int quarters;
	private int dimes;
	private int nickels;
	private int pennies;
	private int singles;
	private int fives;
	
	public Change(int dollars, int cents){
		super(dollars, cents);
	}
	
	public void makeChange(){
	
		fives = dollars/5;
		
		singles = dollars % 5;
		
		quarters = cents/25;
		
		dimes = (cents % 25)/10;
		
		nickels = (cents - (quarters * 25) - (dimes * 10)) / 5;
		
		if(nickels > 0)
			pennies = (cents - (quarters * 25) - (dimes * 10)) % (nickels*5);
		
		else
			pennies = (cents - (quarters * 25) - (dimes * 10));
		
	}
	
	public int getQuarters(){
		return quarters;
	}
	
	public int getDimes() {
		return dimes;
	}
	
	public int getNickels(){
		return nickels;
	}
	
	public int getSingles(){
		return singles;
	}
	
	public int getFives(){
		return fives;
	}	
	
	public int getPennies(){
	return pennies;
	}
}
