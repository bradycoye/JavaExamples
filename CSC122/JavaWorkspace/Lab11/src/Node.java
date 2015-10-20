/**
 * File:	Node.java
 * Author:	Brady Coye
 * Description:	Linked list using generic type
 * 2/23/15
 */

public class Node <E> {
	public E value;
	public Node <E> next;
	
	
	public Node (E val, Node <E> n) {
		value = val;
		next = n;
	}
	
	// default constructor
	public Node () {
		this(null, null);
	}
}