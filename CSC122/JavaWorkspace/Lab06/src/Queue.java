/**
 * File:	Queue.java
 * Author:	Brady Coye
 * Description:	makes queue using circular buffer
 * Last Modified:	2/11/15
 */

public class Queue<Element> {
	private int head, tail, size, items;
	private Element[] array;
	
	public Queue () {
		this (10);
		size = 10;
	}
	
	@SuppressWarnings("unchecked")
	public Queue (int s) {
		size = s;
		array = (Element[]) new Object[size];
		items = 0;
	}
	
	/*
	 * add item to tail of queue
	 */
	public void enqueue (Element c) {
		if (items != 0 && tail == head) {
			head = (++head)%size;
		}
		array[tail] = c;
		items++;
		tail = (++tail)%size;	
		
	}
	
	/*
	 * remove item to head of queue
	 */
	public Element dequeue () {
		Element lastHead = array[head];
			if (items != 0) {
				head = (++head)%size;
				items--;
			}
		return lastHead;
	
		
	}
	/*
	 * return number of items on queue
	 */
	public int count () {
		if (head == tail){
			return 0;
		}
		else {
			return items;
		}
	}
	
	/*
	 * return head of queue but does not remove
	 */
	public Element peek () {
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
			i= (++head)%size;
		}
		System.out.print(readQueue);
		return readQueue;
	}
}