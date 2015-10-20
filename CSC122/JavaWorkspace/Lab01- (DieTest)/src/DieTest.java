/**
 * File:	DieTest.java
 * Author:	Trilby Hren, Brady Coye
 * Description:	Test Die.java's methods.
 * Last Modified:	1/21/15
 */


import static org.junit.Assert.*;
import org.junit.Test;

public class DieTest {


	@Test
	public void createBasics () {
		
		Die d1 = new Die();
		assertTrue (d1.numberOfSides() == 6);
		Die d2 = new Die(6);
		assertTrue (d2.numberOfSides() == 6);
		Die d3 = new Die(32);
		assertTrue (d3.numberOfSides() == 32);
		Die d4 = new Die(2);
		assertTrue (d4.numberOfSides() == 2);
	}
	
	@Test
	public void objectEquality () {
		Die d1 = new Die();
		Die d2 = new Die(6);
		while (d2.getCurrentValue() != 1) {
			d2.roll();
		}		
		assertTrue (d1.equals(d2) == true);
		Die d3 = new Die(32);
		while (d3.getCurrentValue() != 1) {
			d3.roll();
		}
		assertTrue (d1.equals(d3) == false);
	}
	
	@Test
	public void rollRandom() {
		Die d1 = new Die(15);
		int [] rollArray  = new int [15];
		for (int i = 0; i < 6000; i++) {
			d1.roll();
			int value = d1.getCurrentValue();
			rollArray [value - 1] ++;
		}
		for (int j = 0; j < 15; j++) {
			if (rollArray [j] <= 350 || rollArray [j] >= 450){
			fail("Not random");
			}		
		}
	}
}
	

