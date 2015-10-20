/**
 * File:	ParenChecker.java
 * Author:	Brady Coye
 * Description:	uses Stack.java class to check if the 
 * parenthesis, braces, and brackets are formated correctly 
 * Last Modified:	1/29/2015
 */

public class ParenChecker {
	private static final char oPar = '(';
	private static final char cPar = ')';
	private static final char oBracket = '[';
	private static final char cBracket = ']';
	private static final char oBrace = '{';
	private static final char cBrace = '}';

	public static boolean isBalanced(String s) {
		int Stringlength = s.length();
		Stack stack = new Stack ();
		stack.Construct(Stringlength);

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == oPar) {  
				stack.Push(oPar);
			}
				else if (s.charAt(i) == oBrace) {
					stack.Push(oBrace);
				}
				else if (s.charAt(i) == oBracket) {
					stack.Push(oBracket);
				}
				else if (s.charAt(i) == cPar) {
					if (stack.isEmpty()) {
						return false;
					}
					if (stack.Pop() != oPar) {
						return false;
					}
				}
				else if (s.charAt(i) == cBrace) {
					if (stack.isEmpty()){
						return false;
					}
					if (stack.Pop() != oBrace){
						return false;
					}
				}
				else if (s.charAt(i) == cBracket) {
					if (stack.isEmpty()) {
						return false;
					}
					if (stack.Pop() != oBracket) {
					return false;
					}
				}
		}
		return stack.isEmpty();
	}
}