/**
 * File:	Queue.java
 * Author:	Brady Coye
 * Description:	makes queue using circular buffer
 * Last Modified:	2/23/15
 */

public class Queue<Element> {
	private int head, tail, items = 0;
	private Element[] array;

	public Queue () {
		this (10);
	}

	@SuppressWarnings("unchecked")
	public Queue (int s) {
		int size = s;
		array = (Element[]) new Object[size];
	}

	/*
	 * add item to tail of queue. Throws exception if full
	 */
	public void enqueue (Element c) throws Exception{
		if (items != 0 && tail == head) {
			throw new Exception("Queue is Full");
		}
		array[tail] = c;
		items++;
		tail = (++tail)%array.length;	
	}

	/*
	 * remove item to head of queue. Throws exception if empty
	 */
	public Element dequeue () throws Exception {
		if (items == 0) {
			throw new Exception ("Queue is Empty");
		}
		Element lastHead = array[head];
		head = (++head)%array.length;
		items--;
		return lastHead;


	}
	/*
	 * return number of items on queue
	 * 
	 */
	public int count () {

		return items;
	}

	/*
	 * return head of queue but does not remove
	 */
	public Element peek () throws Exception {
		if (items == 0){
			throw new Exception("Queue is Empty");
		}
		return array[head];
	}

	/*
	 * prints string of items on queue
	 */
	public String toString ()  {
		String readQueue ="";
		int i = head;
		while (head != tail) {
			readQueue += array[i] + ", ";
			i= (++head)%array.length;
		}
		return readQueue;
	}
}