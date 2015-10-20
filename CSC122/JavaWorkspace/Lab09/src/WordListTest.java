/**
 * File:	WordListTest.java
 * Author:	Brady Coye
 * Description:	tests the WordList functionality 
 * 3/4/15
 */
import static org.junit.Assert.*;
import org.junit.Test;

/*
 * each case tests the functionality of wordlist with the format: test(method name)
 */
public class WordListTest {

	@Test
	public void testCount() {
		WordList wL = new WordList();
		wL.add("Butter");
		wL.add("Banana");
		wL.add("Peanut");
		assertTrue(wL.count() == 3);
	}
	
	@Test
	public void testGetWordAtPosition() throws Exception {
		WordList wL = new WordList();
		wL.add("Butter");
		wL.add("Banana");
		wL.add("Peanut");
		assertTrue(wL.getWordAtPosition(0) == "Butter");
	}
	
	@Test
	public void testIndexOf() {
		WordList wL = new WordList();
		wL.add("Butter");
		wL.add("Banana");
		wL.add("Peanut");
		assertTrue(wL.indexOf("Butter") == 0);
	}
	
	@Test
	public void testToString() {
		WordList wL = new WordList();
		wL.add("Butter");
		wL.add("Banana");
		wL.add("Peanut");
		assertTrue(wL.toString().equals("Butter Banana Peanut "));
	}
	
	/*
	 * tests the wordlist's ability to expand when full
	 */
	@Test
	public void testWordListCapacity() throws Exception {
		WordList wL = new WordList();
		for (int i=0; i < 15; i++){
		wL.add("Butter");
		wL.add("Banana");
		wL.add("Peanut");
		wL.add("Apple");
		wL.add("Pair");
		}
		assertTrue(wL.count() == 75);
		assertTrue(wL.getWordAtPosition(74).equals("Pair"));
	}
	
	@Test
	public void testMain() throws Exception {
		WordList wL = new WordList();
		wL.main(20);
		wL.toString();
	}

}
