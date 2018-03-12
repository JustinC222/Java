package stack;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class IntStackTestCase {

	@Test
	public void testStackImplementation() {
		IntegerStack stack = new IntegerStack();
		assertTrue(stack.top == 0);
		String line = "53+24-69*62/42+";
		
		
	}
	
	private static void processLine (String line) {

		Scanner keyboard = new Scanner(line).useDelimiter(" ");
		IntegerStack stack = new IntegerStack();
		
		// declare other variables as needed
		String tokenRetrieved;
		int tokenParsed;
		boolean error = false;
		String errorString = "";
		final int MINIMUM_NUMBER_TO_PERFORM_OPERATION = 2;

		
		
		while( (keyboard.hasNext()) && (!error) ) {
			
			
			tokenRetrieved = keyboard.next();
			
			
			System.out.println(tokenRetrieved);
			
			 if(Character.isDigit(tokenRetrieved.charAt(0))){
				tokenParsed = Integer.parseInt(tokenRetrieved);
				System.out.println("Parsed so far: " + tokenParsed);
				
				stack.push(tokenParsed);
				System.out.println("Stack size after parsing: " + stack.size());
			 }
			 
			 else{
				 
				 if(stack.size() < MINIMUM_NUMBER_TO_PERFORM_OPERATION){
					 error = true;
					 errorString = "Error! Not enough Operands.";
					 System.out.println(errorString);
					 System.out.println("Stack Size when error thrown: " + stack.size());
				 }
				 
				 else{
					 
					 String operator = tokenRetrieved;
					 System.out.println("Operator: " + tokenRetrieved);
					
					 int two = Integer.parseInt(stack.peek());
					 System.out.println("Number Two peeked: " + stack.peek());
					 stack.pop();
					 int one = Integer.parseInt(stack.peek());
					 System.out.println("Number One peeked: " + stack.peek());
					 stack.pop();
					 int answer = 0;
					 
					 System.out.println("Stack Size when operation is performed: " + stack.size());
					 switch(operator){
					
					 case "+":
						 answer = one + two;
						 System.out.println("Answer: " + answer);
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
					 	
					 }
					 
					 if(!error)
						 stack.push(answer);
					 
				 } // end else
			 
			 } // end else
			 
		} // end while
		
		
		if( (!error) && ( stack.size() != 1) ){
			error = true;
			errorString = "Calculation ended with more than one value. Try Again.";
		} // end if
		
		System.out.println(line);
		
		if(error)
			System.out.println(errorString);
		
		else{
			System.out.println(stack.peek());
			stack.pop();
		}
		
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
		
	}

}
