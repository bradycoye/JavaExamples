/**
 * File:	Die.java
 * Author:	Trilby Hren, Brady Coye
 * Description:	Creates a die with number of sides determined in main
 * that generates a random number when rolled.
 * Last Modified:	1/14/15
 */

public class Die  {	
	private int numOfSides;			//defined in main class
	private int currentValue;		//value shown after die is rolled		
	
	public Die (int sides) {		
		numOfSides = sides;	
		//currentValue = roll();
	}
	
	public int roll() {
		currentValue = (int)(Math.random() * numOfSides) +1;		// calls java's random to produce a random number in parameters given
		return currentValue;
		
	}
	public int getCurrentValue () {			
		return currentValue;
	}
	
	public String toString() {
		String result = Integer.toString(currentValue);
		return result;
	}
	
	public boolean equals (Object object) {
		if (object instanceof Die && (((Die)object).currentValue == currentValue) && (((Die)object).numOfSides == numOfSides)) {
			return true;
		}
		else {
			return false;
		}
	}
}



