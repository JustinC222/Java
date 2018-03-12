/*
 * 
 * 
 * Purpose: The purpose of this code is to create an array and insert numbers into the array in ascending 
 * order. This code will not sort an array, but will instead enter the number in its correct spot in 
 * ascending order. You can also delete numbers from the array and you don't have to fill the array completely. 
 * The toString method will print only the part of the array that you have filled. 
 *
 *
 */


package orderedArray;


public class OrderedList {

	// Instance variables: 
	private int [] list;
	private int count = 0;
	
	
	// The OrderedList constructor creates new objects of type OrderedList. The size of the array may not be
	// less than 2, if a number less than 2 is entered, an array of size 2 is then created. 
	OrderedList( int num ) {
		
		if ( num < 2 )
			list = new int [ 2 ];
		
		else
			list = new int [ num ];
	}
	
	// This will return the size of the array instantiated when the constructor was called. 
	public int size() {
		return list.length;
	}
	
	
	// This returns the number of entries currently present in the array. This is different from size
	// because this will account for if the array isn't full. 
	public int numEntries(){
		
		return count;
	}
	
	
	// This method inserts numbers into the array. This will take the number to be inserted, compare it to 
	// the numbers currently stored in the array, and place it in the array in ascending order. It will not
	// sort the array, but instead place the number in its proper place from the start. 
	public void insert ( int num ) {
		
		
		// Checking for duplicates within array.
			int position = 0;
			boolean found = false; 
		
			while (  ( position < count ) && ( !found )  ) {
			
			
				if ( num == list [ position ] )  
					found = true;
				
			
				else
					position++;
			
			}
		
			// Checking to see if array is full. If the array is full or if there is a duplicate number, 
			// then the method will then do nothing and the number will not be inserted. 
				if ( count == list.length || found == true){
					// Do Nothing.
				}
			
		
				else{	
			
					// Start to fill array at position 0:
					if( count == 0 ) {                
						list [ count ] = num;
						count++;
					}
			
					// Fills array at positions > 0:
					else {
				
						int index = 0;
						int cutoff = 0;
						boolean stillSearching = true;
				
						// Comparing number inserted to numbers currently in array
						while ( index < count && stillSearching ) {
					
							int numToCompare = list [ index ];
					
							// Cutoff lets me know how many numbers are less than the number to be inserted
							if ( num > numToCompare ) {
					
								cutoff++;
						
							}
					
							// Stops while loop when the correct position for the number to be inserted is found
							else {
								stillSearching = false;
							}
					
							index++;
						} 
				
							index = 0; // reset index
							int[] transferList = new int[list.length];
				
				// This code takes what comes before number, stores it in a separate array, places the number, 
				// and then adds what was left to the created array. It then reassigns list and the number
				// has then been correctly inserted into the array and the numbers after are still intact.
						while ( index < list.length ) {
							if ( index < cutoff ) 
								transferList [ index ] = list [ index ];
					
							else if ( index == cutoff ) 
								transferList [ index ] = num;
					
							else 
								transferList [ index ] = list [ index - 1 ];
					
					
							index++;
						}
				
						list = transferList;
						count++;
				
					}
				}
						
		
		
				  
	}
	
	// This method will perform a linear search algorithm on the number inserted into the parameter, find
	// the number if it's there, delete it, and correct the array accordingly. 
	public void delete ( int terminator ) {
		
		int position = 0;
		boolean found = false; 
		
		while ( ( position < count ) && !found ) {
			
			if ( terminator == list [ position ] )  {
				found = true;
				list [ position ] = 0;
				count--;
			}
			
			while ( found == true && position < count )
			{
				list [ position ] = list [ position + 1 ];
				position++;
			}
			
			position++;
		}
				
	}
	
	// This method will print out the current numbers in the array with a space between each number, 
	// but no spaces before or after the array. 
	public String toString() {
		
		String numberString = "";
		int position = 0;
		
		for( int number = 0; number < count; number++){
			
			if(position == 0){
				numberString = Integer.toString(list[number]);
				position++;
				
			}
				
			else
				numberString += " " + Integer.toString(list[number]);
		}
		
		System.out.println(numberString);
		
		return numberString;
		
	}
	
	
	
	
	} // End of class

