import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void test() {
		LinkedList <Integer> n = new LinkedList();
		n.addFront(1);
		n.addFront(2);
		n.addFront(3);
		n.toString();
	}
	

	@Test
	public void test2() {
		LinkedList <Integer> n = new LinkedList();
		n.addFront(1);
		n.addFront(2);
		n.addFront(3);
		n.removeFront();
		n.toString();
		System.out.println(n.valueAt(1));
	}

}
