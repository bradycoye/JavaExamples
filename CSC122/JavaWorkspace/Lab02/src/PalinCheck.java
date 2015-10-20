import static org.junit.Assert.*;

import org.junit.Test;
/**
 * File:	PalinCheck.java
 * Author:	Brady Coye
 * Description:	determines whether Palindrome App functions correctly=
 * Last Modified:	1/25/2015
 */

public class PalinCheck {

	@Test
	public void testEasy() {
		Palindrome s = new Palindrome("Madam Im Adam");
	
		assertTrue (s.isPalindrome() == true);
	}
	@Test
	public void testMedium() {
		Palindrome s = new Palindrome(" ");
	
		assertTrue (s.isPalindrome() == true);
	}

	@Test
	public void testHard() {
		Palindrome s = new Palindrome("at FGF       ta");
	
		assertTrue (s.isPalindrome() == true);
	}
	
	@Test
	public void testFaile() {
		Palindrome s = new Palindrome("hhgfgghh");
	
		assertTrue (s.isPalindrome() == true);
	}
	
	@Test
	public void test() {
		test s = new test();
	}
	
}
