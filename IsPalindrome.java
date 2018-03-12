/*
 *  
 *
 * Description: This class determines if a word 
 * 				entered by the user is a palindrome. And if so, 
 * 				what type (Types include: Number, Word, or Phrase)
 * 
 */


package palindrome;

import java.util.Scanner;


public class  IsPalindrome
{
	public static int phraseCount = 0;
	
	/*
	 * The main method calls the methods getInputLine, imEmptyLine, isPalindrome, and getPalType. The main will then
	 * print to screen if the word entered by the user in getInputLine is a palindrome or not by calling the isPalindrome 
	 * method, and then what type of palindrome it is by calling the getPalType method. This will continue until isEmptyLine
	 * returns true. 
	 */
	
	public static void main ( String [] args ) 
	{ 
		 
		  String line = getInputLine ( );   
		  
		  while ( !isEmptyLine ( line ) ) 
		  {    
			  
			  if ( isPalindrome ( line ) )     
				  System.out.println ( "\"" + line +       "\" is a palindrome and a " + getPalType ( line ) );   
		  		
		  	  else     
		  		  System.out.println ( "\"" + line + "\" is not a palindrome" );    
			  
			  // resetting class variable phraseCount to 0 before re-running getInputLine
			  phraseCount = 0;
			  
			  line = getInputLine ( ); 
			  	  
			  
		 
		  }   
		  
		  System.out.println ("End of program");  
	}
	
/*
 * getInputLine() is a string method that asks the user to enter word, the word will then be
 * placed into a string variable named input, which will then be returned when the
 * method ends.	
 */
	
	private static String getInputLine ( ) 
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner ( System.in );
		
		System.out.println ( "Enter a line of input" );
		
		String input = scan.nextLine ( );
		
		String newWord = "";
		
		
		for ( int index = 0; index < input.length ( ); index++ )
		{
			char currentChar = input.charAt ( index );
			
			if ( ( Character.isAlphabetic ( currentChar ) ) || ( Character.isDigit ( currentChar ) ) )
			{
					newWord += currentChar;
			}
			
			else
				phraseCount++;
			
		}
		
		return newWord;
	} 
	
	/* 
	 * isEmptyLine is a boolean method that takes a parameter of type String. If the user 
	 * inputs a word, then this method returns the boolean false. However, if the user hits 
	 * the "enter" key, meaning there is no user input, this method will return true.
	 */
	 
	
	private static boolean isEmptyLine ( String str ) 
	{
		if ( str.isEmpty ( ) )
			return true;
		
		else
			return false;
	}
	
	
	/*
	 * isPalindrome is a boolean method that takes as its parameter a String as input. This
	 * method is an algorithm that determines if the word entered by the user is a palindrome. 
	 * 
	 * Essentially, while we are still determining if the word is a palindrome or not and the left
	 * index and right index are still on their respective sides, this method will run. It will work
	 * by skipping over punctuation and turn each indexed letter to its capitalized form. It will then 
	 * compare the two characters by determining if their Unicode values are the same. If they are, the
	 * while loop will continue to run and increment the left and right integer variables. If they are not
	 * equal, okay becomes false and we exit the loop and it is determined as not a palindrome.
	 */
	
	private static boolean isPalindrome ( String str ) 
	{
		int left = 0;
		int right = str.length ( ) - 1;
		boolean okay = true;
		
		
		while ( ( okay ) && ( left < right ) )
		{
			Character ch1 = str.charAt ( left );
			Character ch2 = str.charAt ( right );
			
			if ( (( !Character.isAlphabetic ( ch1 ) ) && ( !Character.isDigit ( ch1 ) )) || Character.isWhitespace(ch1) )
					left++;
					
				
			else
				ch2 = str.charAt ( right );
			
		
			
			if ( ( !Character.isAlphabetic ( ch2 ) ) && ( !Character.isDigit ( ch2 ) ) )
			{
				right--;
				ch1 = Character.toUpperCase ( str.charAt ( left ) );
				ch2 = Character.toUpperCase ( str.charAt ( right ) );
				
			}
			
			
			else
			{
					ch1 = Character.toUpperCase ( str.charAt ( left ) );
					ch2 = Character.toUpperCase ( str.charAt ( right ) );
			}
				
			
			
			if ( ch1 == ch2 )
				{
					left++;
					right--;
				}		
		
			
			else
				okay = false;
		}
		
		return okay;
	}

	/*
	 * getPalType is a String method that takes as its parameter a string. getPalType will then use some 
	 * Character class methods (isDigit and isAlphabetic) and output the type of palindrome entered. The 
	 * three types of palindromes are number, word, and phrase. 
	 * 
	 * getPalType starts by creating three counter variables, one for each of the three types of palindromes. I 
	 * then put the string entered into a character array and each index of the array into the method isDigit and
	 * isAlphabetic (This lets me count each time a letter is a number, word, or phrase). If all characters are
	 * what is classified as a word, then the method returns the palindrome was a word. If all numbers with some 
	 * punctuation, then the method returns a number. Anything else gets returned as a phrase. 
	 */
	
	private static String getPalType ( String line ) 
	{
		
		char [ ] lineArray = new char[ line.length ( ) ];
		
		int isANumber = 0;
		int isAWord = 0;
		
		String returnThis = "";
		
		
		
		for ( int index = 0; index < line.length( ); index++ )
		{
			lineArray [ index ] = line.charAt ( index );
		
			
			if ( Character.isDigit ( lineArray [ index ] ) == true )		
				isANumber++;
			
			
			else if ( Character.isAlphabetic(lineArray[index]) == true )
				isAWord++;
			
			
			
			
		}
		
				
		
		if ( isANumber == line.length ( ) || ( (isANumber > 0 ) && ( phraseCount > 0 ) && ( isAWord == 0 ) ) )
			returnThis = "number";
		
		
		else if ( isAWord == line.length ( ) && phraseCount == 0 )
			returnThis= "word";
		
		
		else if ( ( isANumber >= 0 ) && ( phraseCount > 0 ) && ( isAWord >= 0 ) )
			returnThis= "phrase";
		
		
		
		return returnThis;

	}

	


	

}
