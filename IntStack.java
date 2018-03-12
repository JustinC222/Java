/* 
 * 
 * 
 * Purpose of Program: This program will take in user input as a string, check to see if each separate token (delimited by whitespace) is a 
 * digit, parse it and place it into an integer stack. If it is not an int but is instead an operator, the program will perform a switch statement
 * depending on which operator and perform the mathematical function associated with that operator and the two most top integers in the stack.
 * It will then output what you entered into the program and what the following answer will be.
 * 
 */
package stack;

import java.util.*;

public class IntStack {

	public static void main (String [] args) {

		Scanner input = new Scanner (System.in);
		String line;
		System.out.println ("Enter an expression: ");
		line = input.nextLine();
		

		while (line.length() != 0) {
			processLine (line);
			System.out.println ("Enter an expression: ");
			line = input.nextLine();
		}
		
		System.out.println ("Program complete");
	}

	// This method will take in user input, parse the integers and push them into an object of type IntegerStack, and then perform the associated 
	// mathematical operations based on the type of operators entered and the two most recently entered int's in the arrayList (stack) in the 
	// order they were received.
	private static void processLine (String line) {

		Scanner keyboard = new Scanner(line).useDelimiter(" ");
		IntegerStack stack = new IntegerStack();
		
		// declare other variables as needed
		String tokenRetrieved;
		String errorString = "";
		int tokenParsed;
		final int MINIMUM_NUMBER_TO_PERFORM_OPERATION = 2;
		boolean error = false;
		
		
	
		while( (keyboard.hasNext()) && (!error) ) {
			
			// takes in user input and assigns it to the string "tokenRetrieved"
			tokenRetrieved = keyboard.next();
			
			
			// Checks to see if the first character in the string delimited by whitespace is a digit or not
			 if(Character.isDigit(tokenRetrieved.charAt(0))){
				
				 tokenParsed = Integer.parseInt(tokenRetrieved);
	
				stack.push(tokenParsed);
			}
			 
			 else{
				 
				 // If the first character was not a digit but instead an operator and there are not enough int's in the stack, throw an error:
				 if(stack.size() < MINIMUM_NUMBER_TO_PERFORM_OPERATION){
					 error = true;
					 errorString = "Error! Not enough Operands. Try again.";
					
				 }
				 
				 else{ // Otherwise perform the mathematical operation
					 
					 String operator = tokenRetrieved;
					 
					 int two = Integer.parseInt(stack.peek());
					 stack.pop();
					 
					 int one = Integer.parseInt(stack.peek());
					 stack.pop();
					 
					 int answer = 0;
					 
					 
					 switch(operator){
					
					 case "+":
						 answer = one + two;
					 	break;
					 	
					 case "-":
						 answer = one - two;
					 	break;
					 	
					 case "*":
						 answer = one * two;
					 	break;
					 	
					 case "/":
						 answer = one / two;
					 	break;
					 	
					 } // end switch
					 
					 if(!error)
						 stack.push(answer);
					 
				 } // end else
			 
			 } // end else
			 
		} // end while
		
		
		// Catch the case where there was not enough operators entered in user input
		if( (!error) && ( stack.size() != 1) ){
			error = true;
			errorString = "Error! Not enough Operators. Try again.";
		}
		
		
		// Display to user what they entered as input and the associated answer from the program:
		System.out.println("You entered: " + line);
		
		if(error)
			System.out.println(errorString);
		
		else{
			System.out.println("Your answer is: " + stack.peek());
			stack.pop();
		}
		
		
		
	}// end processLine Method
	
	
}// end IntStack class




// Instructions given by teacher in case needed for reference:



/*
while there are more tokens and not an error
	get the token
	if the token is a digit
		convert the token to an integer and push it on the stack
	else
		if there are not enough values on the stack
			set error to true and set the error string
		else
			pop two values from the stack
			perform the operation
			if not an error
				 push answer on stack
			end if
		end if
	end if
end while
if not an error so far but not just one value on stack
	set the error string
end if
print the input line
if an error occurred
	print the error string set earlier
else
	pop and print the answer
end if
*/
