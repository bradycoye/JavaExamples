import static org.junit.Assert.*;
import org.junit.Test;
/**
 * File:	ParenCheckerTest.java
 * Author:	Brady Coye
 * Description:	determines whether ParenChecker class functions correctly
 * Last Modified:	1/29/2015
 */

public class ParenCheckerTest {

	@Test
	public void testParen() {
		ParenChecker s = new ParenChecker();
		String testString = "()";
		
		assertTrue (s.isBalanced(testString) == true);
	}
	
	@Test
	public void testAll() {
		ParenChecker s = new ParenChecker();
		String testString = "[{()}]";
		
		assertTrue (s.isBalanced(testString) == true);
	}
	
	@Test
	public void testAllExtra() {
		ParenChecker s = new ParenChecker();
		String testString = "[{sd;lfkjsad(lsakdjf;lksadj)dlksf;sdlk}]";
		
		assertTrue (s.isBalanced(testString) == true);
	}
	
	@Test
	public void testAllDuplicate() {
		ParenChecker s = new ParenChecker();
		String testString = "[{()}}]";
		
		assertTrue (s.isBalanced(testString) == false);
	}

	@Test
	public void testAllOrder() {
		ParenChecker s = new ParenChecker();
		String testString = "[{(})}]";
		
		assertTrue (s.isBalanced(testString) == false);
	}
}
