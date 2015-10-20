/**
 * File:	Palindrome.java
 * Author:	Brady Coye
 * Description:	determines whether letters in the string are the same 
 * forwards and backwards
 * Last Modified:	1/25/2015
 */


public class Palindrome {
    
	private String input;

	
    public Palindrome(String test) {
	input = test.toUpperCase();
	

    }
    
    public boolean isPalindrome() {
       
    	if (input != null && input.length() > 0) {
    			
    		int first = 0;
    		int last = input.length() - 1;
    		
    		for (; first < last; first++, last--) {
    			while (input.charAt(first) == ' '){
    				first++;
    			}
    			while (input.charAt(last) == ' '){
    				last--;
    			}	
    			if (input.charAt(first) != input.charAt(last)) {
    				return false;
    			}
    		}
    		return true;
    			
   		}
   		return false;
    }
}
    
