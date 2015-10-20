/**
 * File:	Main.java
 * Author:	Trilby Hren, Brady Coye
 * Description:	Passes number of sides specified into Die class.
 * Last Modified:	1/14/15
 */

public class Main {
	public static void main (String[] args) {
		int totalSides = 13;
		Die die = new Die(totalSides);
		die.roll();
	}	
	
}



