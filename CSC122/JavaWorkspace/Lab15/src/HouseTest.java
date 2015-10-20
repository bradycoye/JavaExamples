import static org.junit.Assert.*;

import org.junit.Test;


public class HouseTest {

	@Test
	public void testEasy() {
		House s = new House(10);
		assertTrue (s.isPalindrome("MADAMIMADAM") == true);
	}
	@Test
	public void testMedium() {
		House s = new House(10);

		assertTrue (s.isPalindrome(" ") == true);
	}

	@Test
	public void testHard() {
		House s = new House(10);

		assertTrue (s.isPalindrome("at FGF       ta") == true);
	}

	@Test
	public void testCorrect() {
		House s = new House(10);

		assertTrue (s.isPalindrome("hhgghh") == true);
	}
	@Test
	public void testFinal() {
		House s = new House(10);

		s.main();
		
	}

}
