/**
 * NOTE: There is currently no validation when pushing onto a full stack * NOTE: There is currently no validation when popping an empty stack
 * @author bryancatron
 * @date Jan 28,2015
 */
public class StackExample<Element> { 
	private Element[ ] arrStack; 
	private int top;
	private final int MAX_SIZE;

	/**
	 * Creates a stack of 10 */
	public StackExample () 
	{
		this (10); 
	}
	/**
	 * Creates a stack of the given maximum size * @param max
	 */
	@SuppressWarnings("unchecked") 
	public StackExample (int max)
	{
		if (max > 0) MAX_SIZE = max;
		else
			MAX_SIZE = 10;

		￼￼arrStack = (Element[]) new Object[MAX_SIZE];
		top = -1; 
	}

	//stack as an array //current top ...
	/**
	 * Returns true if the stack has any valid items on it * @return
	 */
	public boolean isEmpty() {
		return top < 0; 
	}
	

	/**
	 * Adds the given integer to the top of the stack * @param value
	 */
	public void push (Element value) {
		if (top < MAX_SIZE) return;
		top++;
		arrStack[top] = value;
	}
		/**
		 * Removes the top item on the stack * @return
		 */
		public Element pop () {
			if (isEmpty()) return null;
			Element val = arrStack[top]; top--;
			return val;
		}
	}