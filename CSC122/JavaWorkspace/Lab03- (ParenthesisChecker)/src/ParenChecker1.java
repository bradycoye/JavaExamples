/**
 * File:	ParenChecker.java
 * Author:	Brady Coye, Austin Pretsch
 * Description:	creates a usable stack from an array 
 * forwards and backwards
 * Last Modified:	1/28/2015
 */


public class ParenChecker1 {
	private static final char oPar = '(';		
	private static final char cPar = ')';

	public static boolean isBalanced(String s) {
		int Stringlength = s.length();
		Stack stack = new Stack ();
		stack.Construct(Stringlength);

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == oPar) {  
				stack.Push(oPar);
			}
			else if (s.charAt(i) == cPar) {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.Pop() != oPar) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}