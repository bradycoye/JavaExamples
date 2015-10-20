import static org.junit.Assert.*;

import org.junit.Test;
/**
 * File:	QueueTest.java
 * Author:	Brady Coye
 * Description:	tests queue using circular buffer
 * Last Modified:	2/11/15
 */

public class QueueTest {

	@Test
	public void testCount() {
		Queue queue = new Queue();
		assertTrue (queue.count() == 0);
	}
	
	@Test
	public void testpeek() {
		Queue queue = new Queue();
		assertTrue (queue.peek() == 'e');
	}

	@Test
	public void testAll() {
		Queue queue = new Queue();
		queue.enqueue('a');
		queue.enqueue('b');
		queue.enqueue('c');
		queue.enqueue('d');
		queue.enqueue('e');
		assertTrue (queue.peek() == 'a');
		queue.dequeue();
		assertTrue (queue.peek() == 'b');
		queue.dequeue();
		assertTrue (queue.peek() == 'c');
		queue.dequeue();
		assertTrue (queue.peek() == 'd');
		queue.dequeue();
		assertTrue (queue.peek() == 'e');
	}
	
	@Test
	public void testWrap() {
		Queue queue = new Queue();
		queue.enqueue('a');
		queue.enqueue('b');
		queue.enqueue('c');
		queue.enqueue('d');
		queue.enqueue('e');
		queue.enqueue('f');
		queue.enqueue('g');
		queue.enqueue('h');
		queue.enqueue('i');
		queue.enqueue('j');
		queue.enqueue('k');
		for (int i = 0; i<9; i++){
			queue.dequeue();
		}
		assertTrue (queue.peek() == 'k');
	}
	
	@Test
	public void testString() {
		Queue queue = new Queue();
		queue.enqueue('a');
		queue.enqueue('b');
		queue.enqueue('c');
		queue.enqueue('d');
		queue.enqueue('e');
		queue.enqueue('f');
		queue.enqueue('g');
		queue.enqueue('h');
		queue.enqueue('i');
		queue.enqueue('j');
		queue.enqueue('k');
		String str = queue.toString();
	}
	
}
