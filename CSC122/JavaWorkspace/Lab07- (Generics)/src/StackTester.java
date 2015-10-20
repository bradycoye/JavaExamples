import static org.junit.Assert.*;

import org.junit.Test;

public class StackTester {

	@Test
	public void testEmpty() {
		Stack s = new Stack();
		s.Construct(3);
		s.Push(1);
		s.Pop();

		assertTrue(s.isEmpty() == true);
	}

	@Test
	public void testString() throws Exception{
		Stack<String> s = new Stack<String>(2);
		
		s.push("Hello");
		s.push("Hello");
		s.push("Hello");
		String s1 = s.pop();
		assertTrue(s1 == s.pop());
		// s.toString();

	}

	@Test
	public void Construct() {
		Stack s = new Stack();
		s.Push(1);
		s.Push(2);
		s.Push(3);
		s.Push(4);
		s.Push(5);
		s.Push(6);
		s.Push(7);
		s.Push(8);

		s.Pop();
		s.toString();
	}

	@Test
	public void testPop() {
		Stack s = new Stack();
		s.Construct(3);
		s.Push(1);
		s.Push(2);
		s.Pop();
		// s.toString();

		// s.toString();

	}

	@Test
	public void testParen() {
		ParenChecker s = new ParenChecker();
		String testString = "((jsd;lakfj;asd[,nl,mn.,mnkljdsahf{}]))";

		assertTrue(s.isBalanced(testString) == true);
	}

}
