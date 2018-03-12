package bank;

public class ChangeTester {

	public static void main(String[] args){
	Change test = new Change(19,69);
	test.makeChange();
	System.out.println("Fives: " + test.getFives());
	System.out.println("Singles: " + test.getSingles());
	System.out.println("Quarters: " + test.getQuarters());
	System.out.println("Dimes: " + test.getDimes());
	System.out.println("Nickels: " + test.getNickels());
	System.out.println("Pennies: " + test.getPennies());
	
	}
}