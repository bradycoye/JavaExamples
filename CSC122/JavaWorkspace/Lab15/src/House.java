import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * File:	House.java
 * Author:	Brady Coye
 * Description:	fib sequence, palindrome recursive checker, and collection sort example using an arraylist
 * measurements for the development
 * 3/17/15
 */

public class House implements Comparable<House> {
	private int area;
	private ArrayList<House> random;
	/*
	 * Constructor for House that takes the initial square footage
	 */
	public House (int sqFoot) {
		area = sqFoot;
	}
	public int getArea () {	
		return area;
	}
	public int fibonacciCalc (int n) {
		if (n == 0){
			return 0;
		}
		if (n == 1){
			return 1;
		} else {
			return fibonacciCalc (n-1) + fibonacciCalc (n-2);
		}
	}
	public boolean isPalindrome(String test) {
		if (test.length() == 0) {
			return true;
		}
		if (test.length() == 1) {
			return true;
		}
		int first = 0;
		int last = test.length()-1;
		if (test.charAt(first) == test.charAt(last)) {
			if (isPalindrome(test.substring(1, test.length()-1))) {
				return true;
			}
			return false;
		} 
		else {
			return false;
		}
	}
	public int compareTo(House other) {
		return Integer.valueOf(this.getArea()).compareTo(Integer.valueOf(other.getArea()));
	}
	public String toString(ArrayList<House> s) {
		String string = "";
		for (int i=0; i< s.size(); i++){
			House temp = s.get(i);
			string += temp.getArea() + ", ";
		}
		return string;

	}
	/*
	 * Creates an arrayList with 5 houses, each with a different area. Collections then sorts by area 
	 * from smallest to largest and prints out
	 */
	public void main() {
		ArrayList<House> random = new ArrayList<House>(5);
		House one = new House(14);
		House two = new House(49);
		House three = new House(33);
		House four = new House(43);
		House five = new House(29);
		random.add(one);
		random.add(two);
		random.add(three);
		random.add(four);
		random.add(five);

		Collections.sort(random);
		System.out.println(toString(random));
	}
}









