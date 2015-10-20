/**
 * File:	Stack.java
 * Author:	Brady Coye, Austin Pretsch
 * Description:	creates a usable stack from an array 
 * forwards and backwards
 * Last Modified:	1/28/2015
 */

// Creates array for stack
public class Stack {
	private int[] array = new int [10];
	// Sets count (counter) equal to zero
	private int count=0;
	
	//main method
	public void Construct (int n) {
		array = new int [n];
		
	}
	// push method adds value to top of stack
	public void Push(int num){
		if (count <= array.length){
			array [count] = num;
			count++;
		}
			
	}
	// pop takes away value from top of stack
	public int Pop() {
		int give = 0;
		count--;
		give = array[count];
		return give;
	}
	// boolean returns whether or not stack is empty
	public boolean isEmpty (){
		if (count <= 0){
			return true;
		}
		else {
			return false;
		}
	}
	// Returns all contents of stack
	public String toString(){
		String readStack ="";
		for (int i = 0; i < count; i++) {
			readStack += array[i] + ", ";
		}
		System.out.print(readStack);
		return readStack;
	}
}