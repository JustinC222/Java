/* 
 *  
 * Program Description: This class can create bank account objects that can have CreateBankAccount added or 
 * 						subtracted from them and also lets you view your current balance. 
 */

package bank;

import java.text.DecimalFormat;


public class CreateBankAccount 
{
	
	 int dollars;
	 int cents;

	
// Constructor that takes another object as its parameter and sets its instance variables equal to the 
// objects' that is passed in.

	public CreateBankAccount(CreateBankAccount other)
{
	this.dollars = other.dollars;
	
	this.cents = other.cents;
}


// Second constructor that takes two integer values as its parameters and sets its instance variables 
// "dollars" and "cents" equal to the integer values passed in. 

public CreateBankAccount(int dollarsIn, int centsIn)
{
	
	if (dollarsIn > 0)
		dollars = dollarsIn;
	
	
	if (centsIn > 0)
		cents = centsIn;
	
	// when both inputs are negative, dollars and cents gets set to 0
	if ( dollarsIn < 0 && centsIn < 0 )
	{
		dollarsIn = 0;
		
		centsIn = 0;
	}
	
	// Handles when cents entered is negative but between 0 and -99
	if ( centsIn > -100)
	{
		dollars--;
		
		cents = centsIn + 100;
	}
		
	// Handles the case when cents entered is more negative than -100
	else if (centsIn < -100)
	{
		dollars = dollars + centsIn/100;
		
	
		if(centsIn/100 < 0)
		{
			dollars--;
		
			cents = 100 + centsIn % 100;
		}
		
	}
	
}
	

// The add method is a void method with another object as its parameter, it will add the other objects
// dollars and cents to its own and adjust for any over/underflow.

public void add (CreateBankAccount CreateBankAccountIn)
{
	this.dollars = this.dollars + CreateBankAccountIn.dollars;
	
	this.cents = this.cents + CreateBankAccountIn.cents;
	
	this.adjust();
}


// Subtract is also another void method that takes another object as its parameter. It will subtract the
// other objects dollars and cents from its own and also adjust for any over/underflow.

public void subtract(CreateBankAccount CreateBankAccountIn)
{
	
	this.dollars = this.dollars - CreateBankAccountIn.dollars;
	
	this.cents = this.cents - CreateBankAccountIn.cents;
	
	this.adjust();
	
}


// The adjust method is a void method that will adjust dollars if the cents entered is more than
// 100 (dollars + 1) or subtract dollars while cents is less than 0, while also updating cents. 

private void adjust()
{
	
	while ( cents > 99 )
	{
		dollars++;
		
		cents = cents - 100;
		
	}
	
	while ( cents < 0 )
	{
		dollars--;
		
		cents = cents + 100;
		
	}
	
	if ( this.dollars < 0 && this.cents < 100 ) 
	{
		this.dollars = 0;
		this.cents = 0;
	}
	
}


//  This method will compare the total value of dollars and cents between both objects
// and return a value. If the object that called the method has more in its account a 1
// will be returned. If the other object has more, a -1. If both are equal, a 0.

public int compareTo(CreateBankAccount CreateBankAccountIn)
{
	int objectOneTotalCents = this.dollars*100 + this.cents;
	
	int objectTwoTotalCents = CreateBankAccountIn.dollars*100 + CreateBankAccountIn.cents;
	
	int returnInt = 0;
	

	if ( objectOneTotalCents - objectTwoTotalCents == 0 )
		returnInt = 0;
	
	
	else if ( objectOneTotalCents - objectTwoTotalCents > 0)
		returnInt = 1;
	
	
	else if (objectOneTotalCents - objectTwoTotalCents < 0)
		returnInt = -1;
	
	
	return returnInt;
	
}


// This method simply compares if the dollars and cents in both account are equal. A boolean is returned.

public boolean equals(CreateBankAccount CreateBankAccountIn)
{
	if((this.dollars == CreateBankAccountIn.dollars) && (this.cents == CreateBankAccountIn.cents))
		return true;
	
	else
		return false;
}


// Displays the objects instance variables "dollars" and "cents" using the DecimalFormat class. 

public String toString()
{
	
	DecimalFormat CreateBankAccountFormatter = new DecimalFormat("###,###,###,###,##0.00");
	
	int dollarsToCents = this.dollars * 100;
	
	int totalCents = dollarsToCents + this.cents;
	
	double amountInDollarsAndCents = (double)totalCents/100;
	
	String returnThis = "$" + CreateBankAccountFormatter.format(amountInDollarsAndCents);
	
	return returnThis;
	
	
}


}
