 /**
 * File:	Stack.java
 * Author:	Brady Coye
 * Description:	creates a usable stack from an array 
 * forwards and backwards
 * Last Modified:	3/3/2015
 */

/*
* Creates a generic array to handle data. Behaves as a stack
*/
public class Stack<Element> {
	private Element[ ] array;
	private final int MAX_SIZE;
	private int count;
	
	/*
	* initializes default stack of 10
	*/
	public Stack () {
		this (10);
	}
	
	/*
	* initializes stack with the size of the parameter
	*/
	@SuppressWarnings("unchecked")
	public Stack (int max) {
		if (max > 0) 
			MAX_SIZE = max;
		else 
			MAX_SIZE = 10;
		array = (Element[]) new Object[MAX_SIZE];
		count = -1; 
	}
	
	/*
	* boolean returns whether or not stack is empty
	*/
	public boolean isEmpty (){
			return count < 0;
		}
	
	/*
	* push method adds value to top of stack
	*/
	public void push(Element num) throws Exception{
		if (count >= MAX_SIZE - 1)
			throw new Exception("Stack is full");
		else 
			count++;
			array [count] = num;		
	}
	
	/*
	* pop takes away value from top of stack
	*/
	public Element pop() throws Exception{
		if (isEmpty())
			throw new Exception("Stack is empty");
		Element give = array[count];
		count--;
		return give;
	}
	
	/*
	* Returns all contents of stack
	*/
	public String toString(){
		String readStack ="";
		for (int i = 0; i < count; i++) {
			readStack += array[i] + ", ";
		}
		return readStack;
	}
}