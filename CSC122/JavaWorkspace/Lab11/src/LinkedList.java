/**
 * File:	LinkedList.java
 * Author:	Brady Coye
 * Description:	Linked list using generic type (FREE PASS)
 * 2/23/15
 */

public class LinkedList <E> {
	private Node <E> head;
	private int count = 0;

	// default constructor for list
	public LinkedList () {
		head = null;
		count = 0;
	}

	public int getCount () {
		return count;
	}

	// add new front value to the list
	public void addFront (E val) {
		Node <E> n = new Node(val, head);
		head = n;
		count ++;
	}
	
	// removes value at front of list
	public E removeFront() {
		if (count == 0) {
			return null;
		} else {
			E temp = head.value;
			head = head.next;
			count--;
			return temp;
		}
	}
	
	// returns value at indicated position
	public E valueAt (int pos) {
		if (pos >= count || pos < 0) {
			return null;
		} else {
			Node<E> n = head;
			for (int i = 0; i < count; i++) {
				if (i == pos) {
					return n.value;
				} else {
					n = n.next;
				}
			}
		}
		return null;
	}

	// converts list to string then prints
	public String toString () {
		String result = "";
		Node <E> current = head;
		while(current != null){
			result += current.value + ", ";
			current = current.next;

		}
		System.out.print("List: " + result);
		return "List: " + result;
	}

}